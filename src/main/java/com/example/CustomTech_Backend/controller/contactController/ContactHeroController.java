package com.example.CustomTech_Backend.controller.contactController;

import com.example.CustomTech_Backend.dto.contactDto.ContactHeroDto;
import com.example.CustomTech_Backend.service.contactService.ContactHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/hero")
public class ContactHeroController {

    @Autowired
    private ContactHeroService service;

    @GetMapping
    public ResponseEntity<List<ContactHeroDto>> getAllHeroes() {
        return ResponseEntity.ok(service.getAllHeroes());
    }

    @PostMapping
    public ResponseEntity<ContactHeroDto> createHero(@RequestBody ContactHeroDto dto) {
        return ResponseEntity.ok(service.createHero(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactHeroDto> updateHero(@PathVariable Long id, @RequestBody ContactHeroDto dto) throws Exception {
        return ResponseEntity.ok(service.updateHero(id, dto));
    }
}
