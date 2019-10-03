package com.codegym.formatter;

import com.codegym.model.Classes;
import com.codegym.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ClassFormatter implements Formatter<Classes> {

    private ClassService classService;

    @Autowired
    public ClassFormatter(ClassService classService) {
        this.classService = classService;
    }
    @Override
    public Classes parse(String text, Locale locale) throws ParseException {
        return classService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Classes object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
