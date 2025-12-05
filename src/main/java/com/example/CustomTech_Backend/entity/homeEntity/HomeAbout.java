package com.example.CustomTech_Backend.entity.homeEntity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "home_about")
@Data
public class HomeAbout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String paragraph1;

    @Column(columnDefinition = "TEXT")
    private String paragraph2;

    @Column(columnDefinition = "TEXT")
    private String audiencesJson; // Will store JSON string like ["Startups","Enterprises"]

    @Column(columnDefinition = "TEXT")
    private String quote;

    public void setId(long l) {

    }
}
