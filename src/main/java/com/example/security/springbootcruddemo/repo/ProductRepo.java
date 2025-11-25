package com.example.security.springbootcruddemo.repo;

import com.example.security.springbootcruddemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
