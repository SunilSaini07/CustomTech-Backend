package com.example.CustomTech_Backend.controller.solutionsController;


import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCtaDto;
import com.example.CustomTech_Backend.service.solutionsService.SolutionsCtaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solutions/cta")
public class SolutionsCtaController {

    private final SolutionsCtaService service;

    public SolutionsCtaController (SolutionsCtaService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<SolutionsCtaDto> getCta(){
        return ResponseEntity.ok(service.getCta());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolutionsCtaDto> updateCta(
            @PathVariable Integer id,
            @RequestBody SolutionsCtaDto dto) {
        return ResponseEntity.ok(service.updateCta(id,dto));
    }
}
