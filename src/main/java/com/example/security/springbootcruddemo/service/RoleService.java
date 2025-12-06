package com.example.security.springbootcruddemo.service;

import com.example.security.springbootcruddemo.model.Role;
import com.example.security.springbootcruddemo.model.User;
import com.example.security.springbootcruddemo.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;
    public Optional<Role> getRole(Long id)
    {
        return this.roleRepo.findById(id);
    }
    public List<Role> getAllRoles() {
        return this.roleRepo.findAll();
    }
    public Role createRole(Role role) {
        return this.roleRepo.save(role);
    }
    public Role saveRole(Role role)
    {
        return this.roleRepo.save(role);
    }
}
