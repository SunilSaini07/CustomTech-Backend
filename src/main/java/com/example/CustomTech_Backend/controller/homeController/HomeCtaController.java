package com.example.CustomTech_Backend.controller.homeController;

import com.example.CustomTech_Backend.dto.homeDto.HomeCtaDto;
import com.example.CustomTech_Backend.service.homeService.HomeCtaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home/cta")
@CrossOrigin
public class HomeCtaController {

    private final HomeCtaService service;

    public HomeCtaController(HomeCtaService service) {
        this.service = service;
    }

    @GetMapping
    public HomeCtaDto getCtaData() {
        return service.getCta();
    }

    @PutMapping("/{id}")
    public HomeCtaDto updateCta(
            @PathVariable Long id,
            @RequestBody HomeCtaDto dto
    ) {
        return service.updateCta(id, dto);
    }
}
