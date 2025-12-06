package com.example.security.springbootcruddemo.dto;

import com.example.security.springbootcruddemo.dto.RoleDto;
import com.example.security.springbootcruddemo.dto.UserDto;
import com.example.security.springbootcruddemo.model.Role;
import com.example.security.springbootcruddemo.model.User;

import java.util.stream.Collectors;

public class DtoMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles().stream()
                .map(DtoMapper::toRoleDto)
                .collect(Collectors.toSet()));
        return dto;
    }

    public static RoleDto toRoleDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());
        return dto;
    }
}
