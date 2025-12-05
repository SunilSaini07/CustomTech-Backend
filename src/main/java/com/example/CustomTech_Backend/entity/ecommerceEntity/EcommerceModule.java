package com.example.CustomTech_Backend.entity.ecommerceEntity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ecommerce_modules")
public class EcommerceModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "module_text", nullable = false, length = 255)
    private String moduleText;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }

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
