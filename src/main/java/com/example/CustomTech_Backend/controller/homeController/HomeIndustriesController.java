package com.example.CustomTech_Backend.controller.homeController;


import com.example.CustomTech_Backend.dto.homeDto.HomeIndustriesDto;
import com.example.CustomTech_Backend.service.homeService.HomeIndustriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/home/industries")
public class HomeIndustriesController {


    @Autowired
    private HomeIndustriesService service;


    @GetMapping
    public ResponseEntity<List<HomeIndustriesDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


    @PutMapping("/{id}")
    public ResponseEntity<HomeIndustriesDto> update(@PathVariable Integer id, @RequestBody HomeIndustriesDto dto) {
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}