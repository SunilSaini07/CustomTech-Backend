package com.example.CustomTech_Backend.entity.industriesEntity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ind_industry")
public class Industries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    private String description;

    @Column(name = "key_title")
    private String keyTitle;

    @Column(name = "key_text1")
    private String keyText1;

    @Column(name = "key_text2")
    private String keyText2;

    @Column(name = "key_text3")
    private String keyText3;

    @Column(name = "key_text4")
    private String keyText4;

    @Column(name = "key_text5")
    private String keyText5;

    private String note;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", updatable = false, insertable = false)
    private Timestamp updatedAt;

    public Industries() {}

    // getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubTitle() { return subTitle; }
    public void setSubTitle(String subTitle) { this.subTitle = subTitle; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getKeyTitle() { return keyTitle; }
    public void setKeyTitle(String keyTitle) { this.keyTitle = keyTitle; }

    public String getKeyText1() { return keyText1; }
    public void setKeyText1(String keyText1) { this.keyText1 = keyText1; }

    public String getKeyText2() { return keyText2; }
    public void setKeyText2(String keyText2) { this.keyText2 = keyText2; }

    public String getKeyText3() { return keyText3; }
    public void setKeyText3(String keyText3) { this.keyText3 = keyText3; }

    public String getKeyText4() { return keyText4; }
    public void setKeyText4(String keyText4) { this.keyText4 = keyText4; }

    public String getKeyText5() { return keyText5; }
    public void setKeyText5(String keyText5) { this.keyText5 = keyText5; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public Timestamp getCreatedAt() { return createdAt; }
    public Timestamp getUpdatedAt() { return updatedAt; }
}
