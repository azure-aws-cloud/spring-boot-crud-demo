package com.example.security.springbootcruddemo.controller;

import com.example.security.springbootcruddemo.model.Department;
import com.example.security.springbootcruddemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/create")
    public Department create() {
        return service.createDept();
    }

    @PutMapping("/update/{id}")
    public Department update(@PathVariable Long id) {
        return service.updateDept(id);
    }

    @GetMapping("/fetch/{id}")
    public Department fetch(@PathVariable Long id) {
        return service.getWithNPlus1Solution(id);
    }

    @PutMapping("/opt/{id}")
    public String optLock(@PathVariable Long id) {
        service.optimisticLockTest(id);
        return "Optimistic lock tested!";
    }
}

