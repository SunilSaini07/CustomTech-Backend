package com.example.CustomTech_Backend.service.contactService;

import com.example.CustomTech_Backend.dto.contactDto.ContactAboutDto;
import com.example.CustomTech_Backend.entity.contactEntity.ContactAbout;
import com.example.CustomTech_Backend.repo.contactRepo.ContactAboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactAboutService {

    @Autowired
    private ContactAboutRepository repository;

    // Convert entity to DTO
    private ContactAboutDto toDto(ContactAbout about) {
        ContactAboutDto dto = new ContactAboutDto();
        dto.setId(about.getId());
        dto.setTitle(about.getTitle());
        dto.setDescription1(about.getDescription1());
        dto.setDescription2(about.getDescription2());
        dto.setImageUrl(about.getImageUrl());
        dto.setButtonText(about.getButtonText());
        dto.setButtonLink(about.getButtonLink());
        dto.setUpdatedAt(about.getUpdatedAt());
        return dto;
    }

    // Get all about records
    public List<ContactAboutDto> getAllAbout() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    // Create new about entry
    public ContactAboutDto createAbout(ContactAboutDto dto) {
        ContactAbout about = new ContactAbout();
        about.setTitle(dto.getTitle());
        about.setDescription1(dto.getDescription1());
        about.setDescription2(dto.getDescription2());
        about.setImageUrl(dto.getImageUrl());
        about.setButtonText(dto.getButtonText());
        about.setButtonLink(dto.getButtonLink());
        about = repository.save(about);
        return toDto(about);
    }

    // Update existing about entry
    public ContactAboutDto updateAbout(Long id, ContactAboutDto dto) throws Exception {
        ContactAbout about = repository.findById(id)
                .orElseThrow(() -> new Exception("About section not found with id " + id));

        about.setTitle(dto.getTitle());
        about.setDescription1(dto.getDescription1());
        about.setDescription2(dto.getDescription2());
        about.setImageUrl(dto.getImageUrl());
        about.setButtonText(dto.getButtonText());
        about.setButtonLink(dto.getButtonLink());

        about = repository.save(about);
        return toDto(about);
    }
}
