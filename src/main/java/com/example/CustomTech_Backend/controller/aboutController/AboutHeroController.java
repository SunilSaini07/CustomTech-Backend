package com.example.CustomTech_Backend.controller.aboutController;

import com.example.CustomTech_Backend.dto.aboutDto.AboutHeroDto;
import com.example.CustomTech_Backend.service.aboutService.AboutHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about/hero")
@CrossOrigin
public class AboutHeroController {

    @Autowired
    private AboutHeroService service;

    @GetMapping
    public AboutHeroDto getHeroSection() {
        return service.getHero();
    }

    @PutMapping("/{id}")
    public AboutHeroDto updateHeroSection(
            @PathVariable Long id,
            @RequestBody AboutHeroDto dto
    ) {
        return service.updateHero(id, dto);
    }
}
