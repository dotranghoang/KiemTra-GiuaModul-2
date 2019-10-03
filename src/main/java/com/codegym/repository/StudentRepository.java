package com.codegym.repository;

import com.codegym.model.Classes;
import com.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student,Long>{
    Iterable<Student> findAllByClasses(Classes classes);

    Page<Student> findAllByClasses_Name(String className, Pageable pageable);
}
