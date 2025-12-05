package com.example.CustomTech_Backend.dto.solutionsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolutionsCardDto {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String bgGradient;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBgGradient() {
        return bgGradient;
    }

    public void setBgGradient(String bgGradient) {
        this.bgGradient = bgGradient;
    }

}
