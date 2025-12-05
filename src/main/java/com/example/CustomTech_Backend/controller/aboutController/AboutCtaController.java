package com.example.CustomTech_Backend.controller.aboutController;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCtaDto;
import com.example.CustomTech_Backend.service.aboutService.AboutCtaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/about/cta")
@CrossOrigin
public class AboutCtaController {

    private final AboutCtaService service;

    public AboutCtaController(AboutCtaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AboutCtaDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AboutCtaDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<AboutCtaDto> create(@RequestBody AboutCtaDto dto) {
        AboutCtaDto created = service.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutCtaDto> update(@PathVariable Long id, @RequestBody AboutCtaDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
