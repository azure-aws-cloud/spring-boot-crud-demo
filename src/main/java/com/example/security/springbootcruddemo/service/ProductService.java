package com.example.security.springbootcruddemo.service;

import com.example.security.springbootcruddemo.model.Product;
import com.example.security.springbootcruddemo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepo repo;

    public List<Product> getAll(){
        return repo.findAll();
    }
    public Optional<Product> getById(Long id){
        return repo.findById(id);
    }
    public Product save(Product product){
        return repo.save(product);
    }
}
