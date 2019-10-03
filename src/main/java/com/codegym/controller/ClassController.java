package com.codegym.controller;

import com.codegym.model.Classes;
import com.codegym.model.Student;
import com.codegym.service.ClassService;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassController {
    @Autowired
    private ClassService  classService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public ModelAndView home(){
        return getAllClass();
    }

    @GetMapping("/view-class/{id}")
    public ModelAndView viewClass(@PathVariable Long id){
        Classes classes = classService.findById(id);

        Iterable<Student> students = studentService.findAllByClasses(classes);

        ModelAndView modelAndView = new ModelAndView("/class/view");
        modelAndView.addObject("classes",classes);
        modelAndView.addObject("students",students);

        return modelAndView;
    }

    @GetMapping("/list-class")
    public ModelAndView getAllClass(){
        Iterable<Classes> classes = classService.findAll();

        ModelAndView modelAndView = new ModelAndView("/class/list");
        modelAndView.addObject("classes",classes);

        return modelAndView;
    }

    @GetMapping("/create-class")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/class/create");
        modelAndView.addObject("class",new Classes());

        return modelAndView;
    }

    @PostMapping("/save-class")
    public ModelAndView saveCategory(@ModelAttribute("class") Classes classes){
        classService.save(classes);

        ModelAndView modelAndView = new ModelAndView("/class/create");
        modelAndView.addObject("class",new Classes());
        modelAndView.addObject("message","Created class successful");

        return modelAndView;
    }

    @GetMapping("/edit-class/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Classes classes = classService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/class/edit");
        modelAndView.addObject("class",classes);

        return modelAndView;
    }

    @PostMapping("/update-class")
    public ModelAndView updateCategory(@ModelAttribute("class") Classes classes) {
        classService.save(classes);

        ModelAndView modelAndView = new ModelAndView("/class/edit");
        modelAndView.addObject("class",classes);
        modelAndView.addObject("message","Updated class successful");

        return modelAndView;
    }

    @GetMapping("/remove-class/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Classes classes = classService.findById(id);

        ModelAndView modelAndView = new ModelAndView("/class/remove");
        modelAndView.addObject("class",classes);

        return modelAndView;
    }

    @PostMapping("/delete-class")
    public String removeCategory(@ModelAttribute("class") Classes classes){
        classService.remove(classes.getId());

        return "redirect:list-class";
    }

}
