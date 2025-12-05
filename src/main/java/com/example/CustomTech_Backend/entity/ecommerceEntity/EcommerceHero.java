package com.example.CustomTech_Backend.entity.ecommerceEntity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ecommerce_hero")
public class EcommerceHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "button1_text", length = 150)
    private String button1Text;

    @Column(name = "button1_link", length = 255)
    private String button1Link;

    @Column(name = "button2_text", length = 150)
    private String button2Text;

    @Column(name = "button2_link", length = 255)
    private String button2Link;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    private void updateTimestamp() {
        updatedAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getButton1Text() { return button1Text; }
    public void setButton1Text(String button1Text) { this.button1Text = button1Text; }

    public String getButton1Link() { return button1Link; }
    public void setButton1Link(String button1Link) { this.button1Link = button1Link; }

    public String getButton2Text() { return button2Text; }
    public void setButton2Text(String button2Text) { this.button2Text = button2Text; }

    public String getButton2Link() { return button2Link; }
    public void setButton2Link(String button2Link) { this.button2Link = button2Link; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
