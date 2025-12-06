package com.example.security.springbootcruddemo.controller;

import com.example.security.springbootcruddemo.dto.DtoMapper;
import com.example.security.springbootcruddemo.dto.UserDto;
import com.example.security.springbootcruddemo.model.Role;
import com.example.security.springbootcruddemo.model.User;
import com.example.security.springbootcruddemo.service.RoleService;
import com.example.security.springbootcruddemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers()
                .stream()
                .map(DtoMapper::toUserDto)
                .toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return userService.getUser(id)
                .map(DtoMapper::toUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        User saved = userService.createUser(user);
        return ResponseEntity.ok(DtoMapper.toUserDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.getUser(id).map(existing -> {
            existing.setUsername(user.getUsername());
            existing.setPassword(user.getPassword());
            existing.setEmail(user.getEmail());
            existing.setRoles(user.getRoles());
            User saved = userService.saveUser(existing);
            return ResponseEntity.ok(DtoMapper.toUserDto(saved));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> patchUser(@RequestBody User user, @PathVariable Long id) {
        return userService.getUser(id).map(existing -> {
            if (user.getUsername() != null) existing.setUsername(user.getUsername());
            if (user.getPassword() != null) existing.setPassword(user.getPassword());
            if (user.getEmail() != null) existing.setEmail(user.getEmail());
            if (user.getRoles() != null) {
                for (Role role : user.getRoles()) {
                    if (role.getId() != null) {
                        Role managedRole = roleService.getRole(role.getId())
                                .orElseThrow(() -> new RuntimeException("Role not found"));
                        if (existing.getRoles().stream().noneMatch(r -> r.getId().equals(managedRole.getId()))) {
                            existing.getRoles().add(managedRole);
                        }
                    } else {
                        existing.getRoles().add(role);
                    }
                }
            }
            User saved = userService.saveUser(existing);
            return ResponseEntity.ok(DtoMapper.toUserDto(saved));
        }).orElse(ResponseEntity.notFound().build());
    }
}
