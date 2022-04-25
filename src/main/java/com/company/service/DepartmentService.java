package com.company.service;

import com.company.model.Department;
import com.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getInfoForAll(){
        List<Department> list = departmentRepository.findAll();
        return list;
    }

    public void addDepartmentInfo(Department department){
        departmentRepository.save(department);
    }
}
