package com.company.repository;

import com.company.model.Employeeinfo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employeeinfo,Integer> {
    List<Employeeinfo> findAll();
    Employeeinfo findById(int id);
}
