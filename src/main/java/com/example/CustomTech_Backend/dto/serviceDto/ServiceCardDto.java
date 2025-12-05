package com.example.CustomTech_Backend.dto.serviceDto;

public class ServiceCardDto {

    private Integer id;
    private String title;
    private String description;

    private String feature_1;
    private String feature_2;
    private String feature_3;
    private String feature_4;

    private String buttonText;
    private String buttonLink;

    public ServiceCardDto() {}

    // getters & setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFeature_1() { return feature_1; }
    public void setFeature_1(String feature_1) { this.feature_1 = feature_1; }

    public String getFeature_2() { return feature_2; }
    public void setFeature_2(String feature_2) { this.feature_2 = feature_2; }

    public String getFeature_3() { return feature_3; }
    public void setFeature_3(String feature_3) { this.feature_3 = feature_3; }

    public String getFeature_4() { return feature_4; }
    public void setFeature_4(String feature_4) { this.feature_4 = feature_4; }

    public String getButtonText() { return buttonText; }
    public void setButtonText(String buttonText) { this.buttonText = buttonText; }

    public String getButtonLink() { return buttonLink; }
    public void setButtonLink(String buttonLink) { this.buttonLink = buttonLink; }
}
