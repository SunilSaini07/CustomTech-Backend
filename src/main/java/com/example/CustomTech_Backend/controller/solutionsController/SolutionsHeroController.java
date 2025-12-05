package com.example.CustomTech_Backend.controller.solutionsController;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsHeroDto;
import com.example.CustomTech_Backend.service.solutionsService.SolutionsHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solutions/hero")
@CrossOrigin
public class SolutionsHeroController {

    @Autowired
    private SolutionsHeroService service;

    @GetMapping
    public SolutionsHeroDto getHeroSection() {
        return service.getHero();
    }

    @PutMapping("/{id}")
    public SolutionsHeroDto updateHeroSection(
            @PathVariable Long id,
            @RequestBody SolutionsHeroDto dto
    ) {
        return service.updateHero(id, dto);
    }
}
