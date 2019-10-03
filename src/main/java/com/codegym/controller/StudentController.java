package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String home(){
        return "/index";
    }

    @RequestMapping("/list")
    public ModelAndView getAllStudent(Pageable pageable){
        Page<Student> students = studentService.findAll(pageable);

        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students",students);

        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student",new Student());

        return modelAndView;
    }

    @PostMapping("/save-student")
    public ModelAndView saveStudent(@ModelAttribute Student student){
        studentService.save(student);

        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student",new Student());
        modelAndView.addObject("message","Created student successful");

        return modelAndView;
    }

    @GetMapping("/edit-student/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Student student = studentService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student",student);

        return modelAndView;
    }

    @PostMapping("/update-student")
    public ModelAndView updateStudent(@ModelAttribute Student student){
        studentService.save(student);

        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message"," Updated student successful");

        return modelAndView;
    }

    @GetMapping("/remove-student/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Student student = studentService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/student/remove");
        modelAndView.addObject("student",student);

        return modelAndView;
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@ModelAttribute("student") Student student) {
        studentService.remove(student.getId());

        return "redirect:list";
    }

}
