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
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/all")
    public List<Employeeinfo> getInfoForAll(){
        List<Employeeinfo> l= employeeRepository.findAll();
        return l;
    }
    @GetMapping(value = "/{id}")
    public Employeeinfo getInfoById(@PathVariable int id){
         employeeinfo = employeeRepository.findById(id);
         return employeeinfo;
    }

    @PutMapping(value = "/update/{id}")
    public void updateInfoUsingId(@PathVariable int id){
        employeeinfo = employeeRepository.findById(id);
        employeeinfo.setEmpSalary(5000);
        employeeRepository.save(employeeinfo);
    }

    @PostMapping(value = "/add")
    public void addNewEmployeeInfo(@RequestBody Employeeinfo employeeinfo, @RequestParam int deptId){
        employeeService.addNewEmployeeInfo(employeeinfo, deptId);
    }

    @PutMapping(value = "/updateDepartForEmp/{empId}/{deptId}")
    public void updateDepartmentForEmployee(@PathVariable int empId, @PathVariable int deptId){
        employeeService.updateDepartmentForEmployee(empId, deptId);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteInfoById(@PathVariable int id){
        employeeRepository.deleteById(id);
    }
}
