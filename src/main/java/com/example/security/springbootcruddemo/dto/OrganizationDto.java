package com.example.security.springbootcruddemo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class OrganizationDto {
    private Long employeeId;
    private String name;

    // Simplified manager info
    private ManagerDto manager;

    // Simplified subordinates list
    private Set<SubordinateDto> subordinates;

    // getters and setters
}
