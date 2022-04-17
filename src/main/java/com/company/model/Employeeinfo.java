package com.company.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Employeeinfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "empSeq")
//    @SequenceGenerator(name = "empSeq", sequenceName = "empSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_salary")
    private int empSalary;

    @ManyToOne
    private Department department;

    public Employeeinfo(){}

    public Employeeinfo(int empId, String empName, int empSalary){
        this.empId=empId;
        this.empName=empName;
        this.empSalary=empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "employeeinfo{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }
}
