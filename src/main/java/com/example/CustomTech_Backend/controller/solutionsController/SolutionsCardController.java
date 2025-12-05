package com.example.CustomTech_Backend.controller.solutionsController;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCardDto;
import com.example.CustomTech_Backend.service.solutionsService.SolutionsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solutions/cards")
@CrossOrigin
public class SolutionsCardController {

    @Autowired
    private SolutionsCardService service;

    @GetMapping
    public List<SolutionsCardDto> getAllCards() {
        return service.getAllCards();
    }

    @GetMapping("/{id}")
    public SolutionsCardDto getCard(@PathVariable Long id) {
        return service.getCardById(id);
    }

    @PutMapping("/{id}")
    public SolutionsCardDto updateCard(
            @PathVariable Long id,
            @RequestBody SolutionsCardDto dto
    ) {
        return service.updateCard(id, dto);
    }
}
