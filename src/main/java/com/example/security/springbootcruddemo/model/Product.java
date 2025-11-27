package com.example.security.springbootcruddemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // Don't include null fields in JSON
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id") // rename field in JSON
    private Long id;

    @NotBlank(message="Name is mandatory")
    @JsonProperty("name") // rename field in JSON
    private String name;

    @NotBlank(message = "description is mandatory")
    private String description;


    @JsonIgnore   // exclude from JSON response
    private String internalCode;


    public static void main(String[] args) {
        try {
            // Create Product object
            Product product = new Product();
            product.setId(1L);
            product.setName("Laptop");
            product.setDescription("High performance gaming laptop");
            product.setInternalCode("SECRET123"); // Will not appear due to @JsonIgnore

            // Convert to JSON
            ObjectMapper mapper = new ObjectMapper();
            String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);

            // Print JSON
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

