package com.example.CustomTech_Backend.controller.serviceController;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCtaDto;
import com.example.CustomTech_Backend.service.serviceService.ServiceCtaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services/cta")
public class ServiceCtaController {

    private final ServiceCtaService service;

    public ServiceCtaController(ServiceCtaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ServiceCtaDto> getCta() {
        return ResponseEntity.ok(service.getCta());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCtaDto> updateCta(
            @PathVariable Integer id,
            @RequestBody ServiceCtaDto dto) {
        return ResponseEntity.ok(service.updateCta(id, dto));
    }
}
