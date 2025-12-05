package com.example.CustomTech_Backend.controller.industriesController;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesHeroDto;
import com.example.CustomTech_Backend.service.industriesService.IndustriesHeroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/industries/hero")
public class IndustriesHeroController {

    private final IndustriesHeroService service;

    public IndustriesHeroController(IndustriesHeroService service) {
        this.service = service;
    }

    /**
     * GET /api/industries/hero
     * Returns the top/first hero row if present, or 204 No Content if none.
     */
    @GetMapping
    public ResponseEntity<IndustriesHeroDto> getHero() {
        IndustriesHeroDto dto = service.getHero();
        if (dto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dto);
    }

    /**
     * PUT /api/industries/hero/{id}
     * Body: { "title": "...", "description": "..." }
     */
    @PutMapping("/{id}")
    public ResponseEntity<IndustriesHeroDto> updateHero(@PathVariable Long id,
                                                        @RequestBody IndustriesHeroDto updateDto) {
        IndustriesHeroDto updated = service.updateHero(id, updateDto);
        return ResponseEntity.ok(updated);
    }
}
