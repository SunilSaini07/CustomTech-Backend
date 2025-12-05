package com.example.CustomTech_Backend.controller.contactController;

import com.example.CustomTech_Backend.dto.contactDto.ContactAboutDto;
import com.example.CustomTech_Backend.service.contactService.ContactAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/about")
public class ContactAboutController {

    @Autowired
    private ContactAboutService service;

    @GetMapping
    public ResponseEntity<List<ContactAboutDto>> getAllAbout() {
        return ResponseEntity.ok(service.getAllAbout());
    }

    @PostMapping
    public ResponseEntity<ContactAboutDto> createAbout(@RequestBody ContactAboutDto dto) {
        return ResponseEntity.ok(service.createAbout(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactAboutDto> updateAbout(@PathVariable Long id, @RequestBody ContactAboutDto dto) throws Exception {
        return ResponseEntity.ok(service.updateAbout(id, dto));
    }
}
