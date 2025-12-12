package com.example.security.springbootcruddemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Organization manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<Organization> subordinates = new HashSet<>();

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
