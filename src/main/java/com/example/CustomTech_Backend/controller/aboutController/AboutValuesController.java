package com.example.CustomTech_Backend.controller.aboutController;

import com.example.CustomTech_Backend.dto.aboutDto.AboutValuesDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutValuesEntity;
import com.example.CustomTech_Backend.service.aboutService.AboutValuesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about/values")
@CrossOrigin
public class AboutValuesController {

    private final AboutValuesService service;

    public AboutValuesController(AboutValuesService service) {
        this.service = service;
    }

    @GetMapping
    public AboutValuesEntity getValues() {
        return service.getValues();
    }

    @PutMapping("/{id}")
    public AboutValuesEntity updateValues(
            @PathVariable Long id,
            @RequestBody AboutValuesDto dto
    ) {
        return service.updateValues(id, dto);
    }
}
