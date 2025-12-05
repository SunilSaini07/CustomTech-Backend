package com.example.CustomTech_Backend.controller.ecommerceController;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceHeroDto;
import com.example.CustomTech_Backend.service.ecommerceService.EcommerceHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce/hero")
public class EcommerceHeroController {

    @Autowired
    private EcommerceHeroService service;

    @GetMapping
    public ResponseEntity<List<EcommerceHeroDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<EcommerceHeroDto> create(@RequestBody EcommerceHeroDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcommerceHeroDto> update(@PathVariable Long id, @RequestBody EcommerceHeroDto dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
