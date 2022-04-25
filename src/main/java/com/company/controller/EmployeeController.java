package com.company.controller;

import com.company.model.Employeeinfo;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {


    @Autowired
    private  Employeeinfo employeeinfo;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public List<Employeeinfo> getInfoForAll(){
        return this.employeeService.getInfoForAll();
    }

    @GetMapping(value = "/{id}")
    public Employeeinfo getInfoById(@PathVariable int id){
        return this.employeeService.getInfoById(id);
    }

    @PutMapping(value = "/update/{id}")
    public void updateEmployeeSalaryUsingId(@PathVariable int id){
        this.employeeService.updateEmployeeSalaryUsingId(id);
    }

    @PostMapping(value = "/add")
    public void addNewEmployeeInfo(@RequestBody Employeeinfo employeeinfo, @RequestParam int deptId){
        this.employeeService.addNewEmployeeInfo(employeeinfo, deptId);
    }

    @PutMapping(value = "/updateDepartForEmp/{empId}/{deptId}")
    public void updateDepartmentForEmployee(@PathVariable int empId, @PathVariable int deptId){
        this.employeeService.updateDepartmentForEmployee(empId, deptId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteInfoById(@PathVariable int id){
        this.employeeService.deleteInfoById(id);
    }
}
