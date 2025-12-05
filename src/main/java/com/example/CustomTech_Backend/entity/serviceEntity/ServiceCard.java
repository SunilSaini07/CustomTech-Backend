package com.example.CustomTech_Backend.entity.serviceEntity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "service_cards")
public class ServiceCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String feature_1;
    private String feature_2;
    private String feature_3;
    private String feature_4;

    @Column(name = "button_text")
    private String buttonText;

    @Column(name = "button_link")
    private String buttonLink;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    public ServiceCard() {}

    // Getters and setters
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

    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
}
