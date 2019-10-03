package com.codegym.repository;

import com.codegym.model.Classes;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassRepository extends PagingAndSortingRepository<Classes,Long> {

}
