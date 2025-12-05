package com.example.CustomTech_Backend.controller.ecommerceController;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceModuleDto;
import com.example.CustomTech_Backend.service.ecommerceService.EcommerceModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecommerce/modules")
public class EcommerceModuleController {

    @Autowired
    private EcommerceModuleService service;

    @GetMapping
    public ResponseEntity<List<EcommerceModuleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<EcommerceModuleDto> create(@RequestBody EcommerceModuleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcommerceModuleDto> update(@PathVariable Long id, @RequestBody EcommerceModuleDto dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
