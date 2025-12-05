package com.example.CustomTech_Backend.controller.serviceController;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCardDto;
import com.example.CustomTech_Backend.service.serviceService.ServiceCardService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/cards")
public class ServiceCardController {

    private final ServiceCardService service;

    public ServiceCardController(ServiceCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceCardDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCardDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCardDto> update(
            @PathVariable Integer id,
            @RequestBody ServiceCardDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
