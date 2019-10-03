package com.codegym.service;

import com.codegym.model.Classes;
import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);

    void save(Student blog);

    void remove(Long e);

    Student findById(Long id);

    Iterable<Student> findAllByClasses(Classes classes);

    Page<Student> findAllByClasses_Name (String className, Pageable pageable);
}
