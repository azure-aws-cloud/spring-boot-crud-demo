package com.example.security.springbootcruddemo.repo;


import com.example.security.springbootcruddemo.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    // Find all employees who report to a given manager
    List<Organization> findByManagerEmployeeId(Long managerId);

    // Optional: find top-level employees (no manager)
    List<Organization> findByManagerIsNull();
}
