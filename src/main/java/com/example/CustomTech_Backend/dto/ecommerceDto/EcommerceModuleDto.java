package com.example.CustomTech_Backend.dto.ecommerceDto;

import java.time.LocalDateTime;

public class EcommerceModuleDto {

    private Long id;
    private String title;
    private String moduleText;
    private LocalDateTime updatedAt;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getModuleText() { return moduleText; }
    public void setModuleText(String moduleText) { this.moduleText = moduleText; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
