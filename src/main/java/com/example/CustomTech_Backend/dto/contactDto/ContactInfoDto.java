package com.example.CustomTech_Backend.dto.contactDto;

import java.time.LocalDateTime;

public class ContactInfoDto {

    private Long id;
    private String mainTitle;
    private String title;
    private String icon;
    private String info;
    private String glow;
    private LocalDateTime updatedAt;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMainTitle() { return mainTitle; }
    public void setMainTitle(String mainTitle) { this.mainTitle = mainTitle; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getInfo() { return info; }
    public void setInfo(String info) { this.info = info; }

    public String getGlow() { return glow; }
    public void setGlow(String glow) { this.glow = glow; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
