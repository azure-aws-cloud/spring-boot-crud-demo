package com.example.security.springbootcruddemo;


import com.example.security.springbootcruddemo.model.Product;
import com.example.security.springbootcruddemo.repo.ProductRepo;
import com.example.security.springbootcruddemo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepo repo;

    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Product> list = List.of(new Product());
        when(repo.findAll()).thenReturn(list);

        List<Product> result = service.getAll();

        assertEquals(1, result.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void testGetById() {
        Product product = new Product();
        product.setId(1L);

        when(repo.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = service.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(repo).findById(1L);
    }

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("Laptop");

        when(repo.save(product)).thenReturn(product);

        Product result = service.save(product);

        assertEquals("Laptop", result.getName());
        verify(repo).save(product);
    }
}

