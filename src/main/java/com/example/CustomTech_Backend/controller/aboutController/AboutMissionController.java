package com.example.CustomTech_Backend.controller.aboutController;

import com.example.CustomTech_Backend.dto.aboutDto.AboutMissionDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutMissionEntity;
import com.example.CustomTech_Backend.service.aboutService.AboutMissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about/mission")
@CrossOrigin
public class AboutMissionController {

    private final AboutMissionService service;

    public AboutMissionController(AboutMissionService service) {
        this.service = service;
    }

    @GetMapping
    public AboutMissionEntity getMission() {
        return service.getMission();
    }

    @PutMapping("/{id}")
    public AboutMissionEntity updateMission(
            @PathVariable Long id,
            @RequestBody AboutMissionDto dto
    ) {
        return service.updateMission(id, dto);
    }
}
