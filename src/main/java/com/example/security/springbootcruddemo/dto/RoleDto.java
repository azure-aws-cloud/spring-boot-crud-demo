package com.example.security.springbootcruddemo.dto;

import lombok.Data;

@Data
public class RoleDto {
    private Long id;
    private String name;
    private String description;

    // getters and setters
}
