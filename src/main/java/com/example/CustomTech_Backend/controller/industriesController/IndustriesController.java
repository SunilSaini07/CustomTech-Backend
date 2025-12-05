package com.example.CustomTech_Backend.controller.industriesController;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesDto;
import com.example.CustomTech_Backend.service.industriesService.IndustriesService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/industries/industry")
public class IndustriesController {

    private final IndustriesService service;

    public IndustriesController(IndustriesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<IndustriesDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndustriesDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndustriesDto> update(@PathVariable Integer id, @RequestBody IndustriesDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
