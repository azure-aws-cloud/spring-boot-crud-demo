package com.example.security.springbootcruddemo.service;

import com.example.security.springbootcruddemo.model.Department;
import com.example.security.springbootcruddemo.model.Employee;
import com.example.security.springbootcruddemo.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;

    @Transactional
    public Department createDept() {

        Department d = new Department();
        d.setName("IT Department");

        // Employee constructor updated → only accepts name
        d.addEmployee(new Employee("Alice"));
        d.addEmployee(new Employee("Bob"));

        return deptRepo.save(d);  // cascade persist on employees
    }

    @Transactional
    public Department updateDept(Long id) {

        Department dept = deptRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        dept.setName("Updated IT");

        // Dirty checking — no save() required
        return dept;
    }

    @Transactional
    public Department mergeExample(Department detached) {

        // save() calls EntityManager.merge() internally
        return deptRepo.save(detached);
    }

    @Transactional(readOnly = true)
    public Department getWithNPlus1Solution(Long id) {
        return deptRepo.fetchWithEmployees(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Transactional
    public void optimisticLockTest(Long id) {

        Department d1 = deptRepo.findById(id).orElseThrow();
        Department d2 = deptRepo.findById(id).orElseThrow();

        d1.setName("Update A");
        d2.setName("Update B");

        // d1 will commit successfully.
        // d2 will throw OptimisticLockingFailureException
        // because @Version column changed.

        // No explicit save() required (dirty checking)
    }
}
