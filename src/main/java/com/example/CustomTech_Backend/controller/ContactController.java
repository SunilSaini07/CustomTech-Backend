package com.example.CustomTech_Backend.controller;

import com.example.CustomTech_Backend.entity.ContactMessage;
import com.example.CustomTech_Backend.repo.ContactMessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactMessageRepository repo;

    public ContactController(ContactMessageRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> createContact(@RequestBody ContactMessage payload) {
        if (repo.existsByEmail(payload.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        ContactMessage saved = repo.save(payload);
        return ResponseEntity
                .created(URI.create("/api/contacts/" + saved.getMsgid()))
                .body(saved);
    }


    @GetMapping
    public List<ContactMessage> listAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactMessage> getById(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContact(
            @PathVariable Long id,
            @RequestBody ContactMessage payload) {

        return repo.findById(id)
                .map(existing -> {
                    existing.setFullname(payload.getFullname());
                    existing.setEmail(payload.getEmail());
                    existing.setMessage(payload.getMessage());
                    repo.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
