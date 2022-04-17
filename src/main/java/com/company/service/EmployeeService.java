package com.company.service;

import com.company.model.Department;
import com.company.model.Employeeinfo;
import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class EmployeeService {

    private Logger LOGGER =  Logger.getLogger("EmployeeService");

    @Autowired
    private Department department;
    @Autowired
    private Employeeinfo employeeinfo;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateDepartmentForEmployee(int empId, int deptId){
        department = departmentRepository.findById(deptId);
        employeeinfo = employeeRepository.findById(empId);
        employeeinfo.setDepartment(department);
        employeeRepository.save(employeeinfo);
    }

    public void addNewEmployeeInfo(Employeeinfo employeeinfo, int deptId){
        if(departmentRepository.findById(deptId) != null){
                employeeinfo.setDepartment(departmentRepository.findById(deptId));
                employeeRepository.save(employeeinfo);
        }
        else{
            LOGGER.info("There is no any department with the department id "+ deptId);
        }
    }


}
