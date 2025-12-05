package com.example.CustomTech_Backend.controller.homeController;

import com.example.CustomTech_Backend.dto.homeDto.HomeSolutionsDto;
import com.example.CustomTech_Backend.service.homeService.HomeSolutionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home/solutions")
@CrossOrigin
public class HomeSolutionsController {

    private final HomeSolutionsService service;

    public HomeSolutionsController(HomeSolutionsService service) {
        this.service = service;
    }

    @GetMapping
    public List<HomeSolutionsDto> getSolutions() {
        return service.getAllSolutions();
    }

    @PutMapping("/{id}")
    public HomeSolutionsDto updateSolution(
            @PathVariable Long id,
            @RequestBody HomeSolutionsDto dto
    ) {
        return service.updateSolution(id, dto);
    }
}
