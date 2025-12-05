package com.example.CustomTech_Backend.entity.homeEntity;
import jakarta.persistence.*;

//import javax.persistence.*;


@Entity
@Table(name = "home_industries")
public class HomeIndustries {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "main_title")
    private String mainTitle;


    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;


    @Column(name = "key_title")
    private String keyTitle;


    @Column(name = "key1")
    private String key1;


    @Column(name = "key2")
    private String key2;


    @Column(name = "key3")
    private String key3;


    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }


    public String getMainTitle() { return mainTitle; }
    public void setMainTitle(String mainTitle) { this.mainTitle = mainTitle; }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    public String getKeyTitle() { return keyTitle; }
    public void setKeyTitle(String keyTitle) { this.keyTitle = keyTitle; }


    public String getKey1() { return key1; }
    public void setKey1(String key1) { this.key1 = key1; }


    public String getKey2() { return key2; }
    public void setKey2(String key2) { this.key2 = key2; }


    public String getKey3() { return key3; }
    public void setKey3(String key3) { this.key3 = key3; }
}