package com.example.security.springbootcruddemo;


import com.example.security.springbootcruddemo.model.Product;
import com.example.security.springbootcruddemo.controller.ProductController;
import com.example.security.springbootcruddemo.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testGetProductById() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");

        when(productService.getById(1L)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/api/product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setName("Laptop");
        product.setDescription("HP Gaming laptop");

        when(productService.save(any())).thenReturn(product);

        mockMvc.perform(post("/api/product")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    void testPatchProduct() throws Exception {

        Product existing = new Product();
        existing.setId(1L);
        existing.setName("OldName");
        existing.setDescription("OldDesc");

        Product patchData = new Product();
        patchData.setId(1L);
        patchData.setName("NewName");

        when(productService.getById(1L)).thenReturn(Optional.of(existing));
        when(productService.save(any())).thenReturn(existing);

        mockMvc.perform(patch("/api/product/1")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(patchData)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("NewName"));
    }
}
