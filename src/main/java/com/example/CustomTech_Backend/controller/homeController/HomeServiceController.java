package com.example.CustomTech_Backend.controller.homeController;

import com.example.CustomTech_Backend.dto.homeDto.HomeServiceDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeService;
import com.example.CustomTech_Backend.service.homeService.HomeServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/home/services")
@CrossOrigin
public class HomeServiceController {

    @Autowired
    private HomeServiceService service;

    @GetMapping
    public List<HomeService> getAllServices() {
        return service.getServices();
    }

    @PutMapping("/{id}")
    public HomeService updateService(
            @PathVariable Long id,
            @RequestBody HomeServiceDto dto
    ) {
        dto.setId(id);
        return service.updateService(dto);
    }
}
