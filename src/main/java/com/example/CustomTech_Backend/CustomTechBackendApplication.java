package com.example.CustomTech_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.CustomTech_Backend")
public class CustomTechBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomTechBackendApplication.class, args);
    }
}

