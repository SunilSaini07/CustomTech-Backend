package com.example.CustomTech_Backend.service.contactService;

import com.example.CustomTech_Backend.dto.contactDto.ContactInfoDto;
import com.example.CustomTech_Backend.entity.contactEntity.ContactInfo;
import com.example.CustomTech_Backend.repo.contactRepo.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactInfoService {

    @Autowired
    private ContactInfoRepository repository;

    private ContactInfoDto toDto(ContactInfo info) {
        ContactInfoDto dto = new ContactInfoDto();
        dto.setId(info.getId());
        dto.setMainTitle(info.getMainTitle());
        dto.setTitle(info.getTitle());
        dto.setIcon(info.getIcon());
        dto.setInfo(info.getInfo());
        dto.setGlow(info.getGlow());
        dto.setUpdatedAt(info.getUpdatedAt());
        return dto;
    }

    public List<ContactInfoDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public ContactInfoDto create(ContactInfoDto dto) {
        ContactInfo info = new ContactInfo();
        info.setMainTitle(dto.getMainTitle());
        info.setTitle(dto.getTitle());
        info.setIcon(dto.getIcon());
        info.setInfo(dto.getInfo());
        info.setGlow(dto.getGlow());
        info = repository.save(info);
        return toDto(info);
    }

    public ContactInfoDto update(Long id, ContactInfoDto dto) throws Exception {
        ContactInfo info = repository.findById(id)
                .orElseThrow(() -> new Exception("Contact info not found with id " + id));

        info.setMainTitle(dto.getMainTitle());
        info.setTitle(dto.getTitle());
        info.setIcon(dto.getIcon());
        info.setInfo(dto.getInfo());
        info.setGlow(dto.getGlow());

        info = repository.save(info);
        return toDto(info);
    }
}
