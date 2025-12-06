package com.example.security.springbootcruddemo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ORGANIZATION")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "NAME", nullable = false)
    private String name;

    // Self-referencing many-to-one: each employee has one manager
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID") // FK column referencing EMPLOYEE_ID
    private Organization manager;

    // Self-referencing one-to-many: a manager can have many subordinates
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<Organization> subordinates = new HashSet<>();

    // equals and hashCode based only on employeeId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        return employeeId != null && employeeId.equals(((Organization) o).getEmployeeId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

