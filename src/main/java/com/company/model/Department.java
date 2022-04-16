package com.company.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "deptSeq")
    @SequenceGenerator(name = "deptSeq", sequenceName = "deptSeq", initialValue = 100, allocationSize = 1)
    @Column(name = "dept_id")
    private int deptId;
    @Column(name = "dept_name")
    private String deptName;

    public Department(){}

    public Department(int deptId, String deptName){
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
