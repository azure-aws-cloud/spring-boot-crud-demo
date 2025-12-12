package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Integer deptID;

    @Column(name = "NAME")
    private String name;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @OneToMany(
            mappedBy = "dept",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Employee> employees = new ArrayList<>();

    // Helpers
    public void addEmployee(Employee emp) {
        if (emp == null) return;
        employees.add(emp);
        emp.setDept(this);
    }

    public void removeEmployee(Employee emp) {
        if (emp == null) return;
        employees.remove(emp);
        emp.setDept(null);
    }

    // Getters / Setters
    public Integer getDeptID() {
        return deptID;
    }

    public void setDeptID(Integer deptID) {
        this.deptID = deptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
