package com.example.security.springbootcruddemo.controller;

import com.example.security.springbootcruddemo.dto.DtoMapper;
import com.example.security.springbootcruddemo.dto.RoleDto;
import com.example.security.springbootcruddemo.model.Role;
import com.example.security.springbootcruddemo.model.User;
import com.example.security.springbootcruddemo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> roles = roleService.getAllRoles()
                .stream()
                .map(DtoMapper::toRoleDto)
                .toList();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Long id) {
        return roleService.getRole(id)
                .map(DtoMapper::toRoleDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody Role role) {
        Role saved = roleService.createRole(role);
        return ResponseEntity.ok(DtoMapper.toRoleDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody Role role, @PathVariable Long id) {
        return roleService.getRole(id).map(existing -> {
            existing.setName(role.getName());
            existing.setDescription(role.getDescription());
            existing.setUsers(role.getUsers());
            Role saved = roleService.saveRole(existing);
            return ResponseEntity.ok(DtoMapper.toRoleDto(saved));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoleDto> patchRole(@RequestBody Role role, @PathVariable Long id) {
        return roleService.getRole(id).map(existing -> {
            if (role.getName() != null) existing.setName(role.getName());
            if (role.getDescription() != null) existing.setDescription(role.getDescription());
            if (role.getUsers() != null) {
                for (User user : role.getUsers()) {
                    if (user.getId() != null && existing.getUsers().stream()
                            .noneMatch(u -> u.getId().equals(user.getId()))) {
                        existing.getUsers().add(user);
                    }
                }
            }
            Role saved = roleService.saveRole(existing);
            return ResponseEntity.ok(DtoMapper.toRoleDto(saved));
        }).orElse(ResponseEntity.notFound().build());
    }
}
