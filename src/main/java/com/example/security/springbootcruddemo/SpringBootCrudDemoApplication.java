package com.example.security.springbootcruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner() {
        return args -> {
            System.out.println("Executing logic after startup...");
        };
    }

}
