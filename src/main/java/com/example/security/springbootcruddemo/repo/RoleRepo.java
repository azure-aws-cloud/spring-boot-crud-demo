package com.example.security.springbootcruddemo.repo;

import com.example.security.springbootcruddemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
