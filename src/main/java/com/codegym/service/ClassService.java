package com.codegym.service;

import com.codegym.model.Classes;

public interface ClassService  {
    Iterable<Classes> findAll();

    Classes findById(Long id);

    void save(Classes classes);

    void remove(Long id);

}