package com.example.security.springbootcruddemo.service;


import com.example.security.springbootcruddemo.model.Organization;
import com.example.security.springbootcruddemo.repo.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public List<Organization> getAllEmployees() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getEmployee(Long id) {
        return organizationRepository.findById(id);
    }

    public Organization saveEmployee(Organization employee) {
        return organizationRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        organizationRepository.deleteById(id);
    }

    // Find all subordinates of a given manager
    public List<Organization> getSubordinates(Long managerId) {
        return organizationRepository.findByManagerEmployeeId(managerId);
    }

    // Find all top-level employees (no manager)
    public List<Organization> getTopLevelEmployees() {
        return organizationRepository.findByManagerIsNull();
    }
}
