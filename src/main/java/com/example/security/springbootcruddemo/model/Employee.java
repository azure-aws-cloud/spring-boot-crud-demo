package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Integer employeeID;

    @Column(name = "FNAME")
    private String fName;

    @Column(name = "LNAME")
    private String lName;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "HIRE_DATE")
    private LocalDateTime hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_EMP_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_COMMENT_ID")
    private EmployeeComment employeeComment;

    // Constructor used by DepartmentService: set first name
    public Employee(String name) {
        this.fName = name;
    }

    public Employee() {}

    // Getters / Setters
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public EmployeeComment getEmployeeComment() {
        return employeeComment;
    }

    public void setEmployeeComment(EmployeeComment employeeComment) {
        this.employeeComment = employeeComment;
    }
}
