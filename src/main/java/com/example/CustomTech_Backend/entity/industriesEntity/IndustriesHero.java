package com.example.CustomTech_Backend.entity.industriesEntity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ind_hero")
public class IndustriesHero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    // Database manages this via: DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    @Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

    public IndustriesHero() {}

    public IndustriesHero(String title, String description) {
        this.title = title;
        this.description = description;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    // no setter for updatedAt since DB handles it
}
