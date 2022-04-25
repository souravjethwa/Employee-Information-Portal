package com.company.service;

import com.company.exception.DepartmentNotFoundException;
import com.company.exception.EmployeeNotFoundException;
import com.company.model.Department;
import com.company.model.Employeeinfo;
import com.company.repository.DepartmentRepository;
import com.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Employeeinfo> getInfoForAll(){
        List<Employeeinfo> list= employeeRepository.findAll();
        if(list.isEmpty()){
            throw new EmployeeNotFoundException("No data Found");
        }
        return list;
    }

    public Employeeinfo getInfoById(int id){
        employeeinfo = employeeRepository.findById(id);
        if(employeeinfo == null){
            throw new EmployeeNotFoundException("Employee is not present with the given id = "+id);
        }
        return employeeinfo;
    }

    public void updateEmployeeSalaryUsingId(int id){
        employeeinfo = employeeRepository.findById(id);
        if(employeeinfo == null){
            throw new EmployeeNotFoundException("Employee is not present with the given id = "+id);
        }
        employeeinfo.setEmpSalary(5000);
        employeeRepository.save(employeeinfo);
    }

    public void addNewEmployeeInfo(Employeeinfo employeeinfo, int deptId){
        if(departmentRepository.findById(deptId) != null){
            employeeinfo.setDepartment(departmentRepository.findById(deptId));
            employeeRepository.save(employeeinfo);
        }
        else{
            throw new DepartmentNotFoundException("There is no any department with the department id = "+ deptId);
        }
    }

    public void updateDepartmentForEmployee(int empId, int deptId){
        employeeinfo = employeeRepository.findById(empId);
        if(employeeinfo == null){
            throw new EmployeeNotFoundException("There is no any employee with the employee id = "+empId);
        }
        department = departmentRepository.findById(deptId);
        if(department == null){
            throw new DepartmentNotFoundException("There is no any department with the department id = "+deptId);
        }
        employeeinfo.setDepartment(department);
        employeeRepository.save(employeeinfo);
    }

    public void deleteInfoById(int id) {
        if(employeeRepository.findById(id) == null) {
            throw new EmployeeNotFoundException("There is no any employee with the employee id = "+id);
        }
        employeeRepository.deleteById(id);
    }
}
