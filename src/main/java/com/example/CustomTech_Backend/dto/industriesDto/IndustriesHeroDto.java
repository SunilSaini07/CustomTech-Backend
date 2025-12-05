package com.example.CustomTech_Backend.dto.industriesDto;

public class IndustriesHeroDto {

    private Long id;
    private String title;
    private String description;
    private String updatedAt;

    public IndustriesHeroDto() {}

    public IndustriesHeroDto(Long id, String title, String description, String updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.updatedAt = updatedAt;
    }

    // getters / setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
