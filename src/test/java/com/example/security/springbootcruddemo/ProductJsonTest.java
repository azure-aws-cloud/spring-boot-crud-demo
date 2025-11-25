package com.example.security.springbootcruddemo;


import com.example.security.springbootcruddemo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductJsonTest {

    @Test
    void testJsonSerialization() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setDescription("High performance");
        product.setInternalCode("SECRET123");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);

        assertTrue(json.contains("\"id\":1"));
        assertTrue(json.contains("\"name\":\"Laptop\""));
        assertTrue(json.contains("\"description\":\"High performance\""));

        // internalCode must be excluded
        assertFalse(json.contains("SECRET123"));
        assertFalse(json.contains("internalCode"));
    }
}

