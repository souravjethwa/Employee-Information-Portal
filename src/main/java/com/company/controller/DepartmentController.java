package com.company.controller;

import com.company.model.Department;
import com.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private Department department;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/all")
    public List<Department> getInfoForAll(){
        return this.departmentService.getInfoForAll();
    }

    @PostMapping(value = "/add")
    public void addDepartmentInfo(@RequestBody Department department){
        departmentService.addDepartmentInfo(department);
    }
}
