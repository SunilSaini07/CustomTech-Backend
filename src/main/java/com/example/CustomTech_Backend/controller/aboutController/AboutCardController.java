package com.example.CustomTech_Backend.controller.aboutController;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCardDto;
import com.example.CustomTech_Backend.service.aboutService.AboutCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about/cards")
@CrossOrigin
public class AboutCardController {

    private final AboutCardService service;

    public AboutCardController(AboutCardService service) {
        this.service = service;
    }

    @GetMapping
    public List<AboutCardDto> getAllCards() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public AboutCardDto updateCard(@PathVariable Long id, @RequestBody AboutCardDto dto) {
        return service.update(id, dto);
    }
}
