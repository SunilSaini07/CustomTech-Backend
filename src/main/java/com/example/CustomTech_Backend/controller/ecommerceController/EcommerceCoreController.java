package com.example.CustomTech_Backend.controller.ecommerceController;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceCoreDto;
import com.example.CustomTech_Backend.service.ecommerceService.EcommerceCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce/core")
public class EcommerceCoreController {

    @Autowired
    private EcommerceCoreService service;

    @GetMapping
    public ResponseEntity<List<EcommerceCoreDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<EcommerceCoreDto> create(@RequestBody EcommerceCoreDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcommerceCoreDto> update(@PathVariable Long id, @RequestBody EcommerceCoreDto dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
