package com.example.security.springbootcruddemo.repo;

import com.example.security.springbootcruddemo.model.Department;
import com.example.security.springbootcruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Prevent N+1 problem by JOIN FETCH
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.employees WHERE d.id = :id")
    Optional<Department> fetchWithEmployees(Long id);

    /*
        SELECT d.*, e.*
        FROM department d
        LEFT JOIN employee e ON d.id = e.department_id
        WHERE d.id = 1;
     */
}


