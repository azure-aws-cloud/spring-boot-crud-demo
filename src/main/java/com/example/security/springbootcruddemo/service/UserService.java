package com.example.security.springbootcruddemo.service;

import com.example.security.springbootcruddemo.model.User;
import com.example.security.springbootcruddemo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    final private UserRepo userRepo;

    public Optional<User> getUser(Long id)
    {
        return this.userRepo.findById(id);
    }
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }
    public User createUser(User user) {
        return this.userRepo.save(user);
    }
    public User saveUser(User user)
    {
        return this.userRepo.save(user);
    }
}
