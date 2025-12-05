package com.example.CustomTech_Backend.controller.ecommerceController;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceCtaDto;
import com.example.CustomTech_Backend.service.ecommerceService.EcommerceCtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce/cta")
public class EcommerceCtaController {

    @Autowired
    private EcommerceCtaService service;

    @GetMapping
    public ResponseEntity<List<EcommerceCtaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<EcommerceCtaDto> create(@RequestBody EcommerceCtaDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcommerceCtaDto> update(@PathVariable Long id, @RequestBody EcommerceCtaDto dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
