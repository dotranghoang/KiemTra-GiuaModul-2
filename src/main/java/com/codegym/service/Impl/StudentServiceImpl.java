package com.codegym.service.Impl;

import com.codegym.model.Classes;
import com.codegym.model.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Iterable<Student> findAllByClasses(Classes classes) {
        return studentRepository.findAllByClasses(classes);
    }

    @Override
    public Page<Student> findAllByClasses_Name(String className, Pageable pageable) {
        return studentRepository.findAllByClasses_Name(className,pageable);
    }


}
