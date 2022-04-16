package com.company.controller;

import com.company.model.Department;
import com.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private Department department;
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping(value = "/all")
    public List<Department> getInfoForAll(){
        List<Department> list = departmentRepository.findAll();
        return list;
    }

    @PostMapping(value = "/add")
    public void addDepartmentInfo(@RequestBody Department department){
        departmentRepository.save(department);
    }
}
