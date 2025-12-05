package com.example.CustomTech_Backend.service.contactService;

import com.example.CustomTech_Backend.dto.contactDto.ContactHeroDto;
import com.example.CustomTech_Backend.entity.contactEntity.ContactHero;
import com.example.CustomTech_Backend.repo.contactRepo.ContactHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactHeroService {

    @Autowired
    private ContactHeroRepository repository;

    // Convert entity to DTO
    private ContactHeroDto toDto(ContactHero hero) {
        ContactHeroDto dto = new ContactHeroDto();
        dto.setId(hero.getId());
        dto.setTitle(hero.getTitle());
        dto.setDescription(hero.getDescription());
        dto.setUpdatedAt(hero.getUpdatedAt());
        return dto;
    }

    // Get all hero records
    public List<ContactHeroDto> getAllHeroes() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    // Create new hero
    public ContactHeroDto createHero(ContactHeroDto dto) {
        ContactHero hero = new ContactHero();
        hero.setTitle(dto.getTitle());
        hero.setDescription(dto.getDescription());
        hero = repository.save(hero);
        return toDto(hero);
    }

    // Update existing hero
    public ContactHeroDto updateHero(Long id, ContactHeroDto dto) throws Exception {
        ContactHero hero = repository.findById(id)
                .orElseThrow(() -> new Exception("Hero not found with id " + id));

        hero.setTitle(dto.getTitle());
        hero.setDescription(dto.getDescription());
        hero = repository.save(hero);
        return toDto(hero);
    }
}
