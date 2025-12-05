package com.example.CustomTech_Backend.controller.homeController;

import com.example.CustomTech_Backend.dto.homeDto.HomeHeroDto;
import com.example.CustomTech_Backend.service.homeService.HomeHeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
public class HomeHeroController {

    private final HomeHeroService service;

    public HomeHeroController(HomeHeroService service) {
        this.service = service;
    }

    // Public endpoint used by the frontend
    @GetMapping("/hero")
    public ResponseEntity<?> getHome() {
        HomeHeroDto dto = service.getHero();
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    // Admin update (protect this endpoint in production)
    @PutMapping("/hero")
    public ResponseEntity<?> updateHome(@RequestBody HomeHeroDto incoming) {
        try {
            HomeHeroDto updated = service.updateHero(incoming);
            return ResponseEntity.ok(updated);
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Failed to update");
        }
    }
}
