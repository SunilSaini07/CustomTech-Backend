package com.example.CustomTech_Backend.controller.contactController;

import com.example.CustomTech_Backend.dto.contactDto.ContactInfoDto;
import com.example.CustomTech_Backend.service.contactService.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact/info")
public class ContactInfoController {

    @Autowired
    private ContactInfoService service;

    @GetMapping
    public ResponseEntity<List<ContactInfoDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ContactInfoDto> create(@RequestBody ContactInfoDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInfoDto> update(@PathVariable Long id, @RequestBody ContactInfoDto dto) throws Exception {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
