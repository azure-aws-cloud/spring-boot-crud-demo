package com.example.security.springbootcruddemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @NotBlank(message="Name is mandatory")
    @NotNull
    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name="description")
    @NotNull
    @NotBlank(message = "description is mandatory")
    private String description;

    @JsonIgnore
    @Column(name = "internal_code")
    private String internalCode;
}
