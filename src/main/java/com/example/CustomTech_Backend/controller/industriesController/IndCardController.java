package com.example.CustomTech_Backend.controller.industriesController;

import com.example.CustomTech_Backend.dto.industriesDto.IndCardDto;
import com.example.CustomTech_Backend.service.industriesService.IndCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/industries/card")
public class IndCardController {

    private final IndCardService service;

    public IndCardController(IndCardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<IndCardDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndCardDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IndCardDto> update(
            @PathVariable Integer id,
            @RequestBody IndCardDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
