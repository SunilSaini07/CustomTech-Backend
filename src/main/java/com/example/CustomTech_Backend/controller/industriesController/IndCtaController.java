package com.example.CustomTech_Backend.controller.industriesController;

import com.example.CustomTech_Backend.dto.industriesDto.IndCtaDto;
import com.example.CustomTech_Backend.service.industriesService.IndCtaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/industries/cta")
public class IndCtaController {

    private final IndCtaService service;

    public IndCtaController(IndCtaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<IndCtaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndCtaDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndCtaDto> update(
            @PathVariable Integer id,
            @RequestBody IndCtaDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
