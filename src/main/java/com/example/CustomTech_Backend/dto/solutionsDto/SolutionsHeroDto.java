package com.example.CustomTech_Backend.dto.solutionsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolutionsHeroDto {
    private Long id;
    private String title;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

}
