package com.example.security.springbootcruddemo.rest;

import com.example.security.springbootcruddemo.model.Product;
import com.example.security.springbootcruddemo.service.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping // Default GET method
    String getAllProducts(){
        return "ALL Products";
    }

    /*@GetMapping("/all")
    List<Product> findAllProducts(){
       return this.productService.getAll();
    }
    @GetMapping("byid")
    public Optional<Product> getByQueryParam(@RequestParam Long id) {
        return this.productService.getById(id);
    }*/

    @GetMapping("{id}")
    Optional<Product> getProduct(@PathVariable Long id){
        return this.productService.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return this.productService.save(product);
    }
    @PutMapping
    public Product update(@RequestBody Product product){
        return this.productService.save(product);
    }
    @PatchMapping
    public Product patch(@RequestBody Product product){
        Optional<Product> existingOpt = productService.getById(product.getId());

        Product existing = existingOpt.orElseThrow(
                () -> new RuntimeException("Product not found with id: " + product.getId())
        );

        if (product.getName() != null) {
            existing.setName(product.getName());
        }

        if (product.getDescription() != null) {
            existing.setDescription(product.getDescription());
        }

        // Add other fields as needed

        return productService.save(existing);
    }
}
