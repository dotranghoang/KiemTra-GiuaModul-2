package com.codegym.service.Impl;

import com.codegym.model.Classes;
import com.codegym.repository.ClassRepository;
import com.codegym.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;


    @Override
    public Iterable<Classes> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Classes findById(Long id) {
        return classRepository.findOne(id);
    }

    @Override
    public void save(Classes classes) {
        classRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classRepository.delete(id);
    }
}
