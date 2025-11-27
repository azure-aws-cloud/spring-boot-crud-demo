package com.example.security.springbootcruddemo.rest;

import com.example.security.springbootcruddemo.model.Product;
import com.example.security.springbootcruddemo.service.ProductService;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable  Long id) {
        return productService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @Validated @RequestBody Product product) {

        Product savedProduct = productService.save(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @Validated @RequestBody Product product) {

        return this.productService.getById(id).map(existing->{
            if (product.getName() != null) {
                existing.setName(product.getName());
            }
            if (product.getDescription() != null) {
                existing.setDescription(product.getDescription());
            }
            // Add any other partial update fields...
            return ResponseEntity.ok(productService.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> patchProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.getById(id)
                .map(existing -> {
                    if (product.getName() != null) {
                        existing.setName(product.getName());
                    }
                    if (product.getDescription() != null) {
                        existing.setDescription(product.getDescription());
                    }
                    // Add any other partial update fields...
                    return ResponseEntity.ok(productService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
