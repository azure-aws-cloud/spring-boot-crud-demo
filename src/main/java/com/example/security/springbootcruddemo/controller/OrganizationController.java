package com.example.security.springbootcruddemo.controller;

import com.example.security.springbootcruddemo.dto.OrganizationDto;
import com.example.security.springbootcruddemo.model.Organization;
import com.example.security.springbootcruddemo.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/org")
public class OrganizationController {

    private final OrganizationService organizationService;

    // Get all employees
    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getAllEmployees() {
        List<OrganizationDto> employees = organizationService.getAllEmployees()
                .stream()
                .map(com.example.security.springbootcruddemo.mapper.OrganizationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    // Get a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getEmployee(@PathVariable Long id) {
        return organizationService.getEmployee(id)
                .map(com.example.security.springbootcruddemo.mapper.OrganizationMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<OrganizationDto> createEmployee(@RequestBody Organization employee) {
        Organization saved = organizationService.saveEmployee(employee);
        return ResponseEntity.ok(com.example.security.springbootcruddemo.mapper.OrganizationMapper.toDto(saved));
    }

    // Update an employee fully
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> updateEmployee(@RequestBody Organization employee, @PathVariable Long id) {
        return organizationService.getEmployee(id).map(existing -> {
            existing.setName(employee.getName());
            existing.setManager(employee.getManager());
            Organization saved = organizationService.saveEmployee(existing);
            return ResponseEntity.ok(com.example.security.springbootcruddemo.mapper.OrganizationMapper.toDto(saved));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        organizationService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    // Get all subordinates of a manager
    @GetMapping("/{id}/subordinates")
    public ResponseEntity<List<OrganizationDto>> getSubordinates(@PathVariable Long id) {
        List<OrganizationDto> subs = organizationService.getSubordinates(id)
                .stream()
                .map(com.example.security.springbootcruddemo.mapper.OrganizationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(subs);
    }

    // Get all top-level employees (no manager)
    @GetMapping("/top-level")
    public ResponseEntity<List<OrganizationDto>> getTopLevelEmployees() {
        List<OrganizationDto> topLevel = organizationService.getTopLevelEmployees()
                .stream()
                .map(com.example.security.springbootcruddemo.mapper.OrganizationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(topLevel);
    }
}
