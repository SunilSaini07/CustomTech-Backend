package com.example.CustomTech_Backend.controller.serviceController;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceHeroDto;
import com.example.CustomTech_Backend.service.serviceService.ServiceHeroService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/hero")
public class ServiceHeroController {

    private final ServiceHeroService service;

    public ServiceHeroController(ServiceHeroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceHeroDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceHeroDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceHeroDto> update(
            @PathVariable Integer id,
            @RequestBody ServiceHeroDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
