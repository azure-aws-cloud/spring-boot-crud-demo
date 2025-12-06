package com.example.security.springbootcruddemo.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;   // ✅ no password exposed
    private Set<RoleDto> roles;

    // getters and setters
}
