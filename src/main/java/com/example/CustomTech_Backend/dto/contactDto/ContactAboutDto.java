package com.example.CustomTech_Backend.dto.contactDto;

import java.time.LocalDateTime;

public class ContactAboutDto {

    private Long id;
    private String title;
    private String description1;
    private String description2;
    private String imageUrl;
    private String buttonText;
    private String buttonLink;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription1() { return description1; }
    public void setDescription1(String description1) { this.description1 = description1; }

    public String getDescription2() { return description2; }
    public void setDescription2(String description2) { this.description2 = description2; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getButtonText() { return buttonText; }
    public void setButtonText(String buttonText) { this.buttonText = buttonText; }

    public String getButtonLink() { return buttonLink; }
    public void setButtonLink(String buttonLink) { this.buttonLink = buttonLink; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
