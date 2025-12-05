package com.example.CustomTech_Backend.service.ecommerceService;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceHeroDto;
import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceHero;
import com.example.CustomTech_Backend.repo.ecommerceRepo.EcommerceHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcommerceHeroService {

    @Autowired
    private EcommerceHeroRepository repository;

    private EcommerceHeroDto toDto(EcommerceHero entity) {
        EcommerceHeroDto dto = new EcommerceHeroDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setButton1Text(entity.getButton1Text());
        dto.setButton1Link(entity.getButton1Link());
        dto.setButton2Text(entity.getButton2Text());
        dto.setButton2Link(entity.getButton2Link());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public List<EcommerceHeroDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public EcommerceHeroDto create(EcommerceHeroDto dto) {
        EcommerceHero entity = new EcommerceHero();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setButton1Text(dto.getButton1Text());
        entity.setButton1Link(dto.getButton1Link());
        entity.setButton2Text(dto.getButton2Text());
        entity.setButton2Link(dto.getButton2Link());
        entity = repository.save(entity);
        return toDto(entity);
    }

    public EcommerceHeroDto update(Long id, EcommerceHeroDto dto) throws Exception {
        EcommerceHero entity = repository.findById(id)
                .orElseThrow(() -> new Exception("EcommerceHero not found with id " + id));

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setButton1Text(dto.getButton1Text());
        entity.setButton1Link(dto.getButton1Link());
        entity.setButton2Text(dto.getButton2Text());
        entity.setButton2Link(dto.getButton2Link());

        entity = repository.save(entity);
        return toDto(entity);
    }
}
