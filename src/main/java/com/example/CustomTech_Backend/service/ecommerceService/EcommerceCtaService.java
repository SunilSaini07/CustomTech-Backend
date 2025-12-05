package com.example.CustomTech_Backend.service.ecommerceService;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceCtaDto;
import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceCta;
import com.example.CustomTech_Backend.repo.ecommerceRepo.EcommerceCtaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcommerceCtaService {

    @Autowired
    private EcommerceCtaRepository repository;

    private EcommerceCtaDto toDto(EcommerceCta entity) {
        EcommerceCtaDto dto = new EcommerceCtaDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setButtonText(entity.getButtonText());
        dto.setButtonLink(entity.getButtonLink());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private EcommerceCta toEntity(EcommerceCtaDto dto) {
        EcommerceCta e = new EcommerceCta();
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setButtonText(dto.getButtonText());
        e.setButtonLink(dto.getButtonLink());
        return e;
    }

    public List<EcommerceCtaDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public EcommerceCtaDto create(EcommerceCtaDto dto) {
        EcommerceCta entity = toEntity(dto);
        entity = repository.save(entity);
        return toDto(entity);
    }

    public EcommerceCtaDto update(Long id, EcommerceCtaDto dto) throws Exception {
        EcommerceCta entity = repository.findById(id)
                .orElseThrow(() -> new Exception("EcommerceCta not found with id " + id));
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setButtonText(dto.getButtonText());
        entity.setButtonLink(dto.getButtonLink());
        entity = repository.save(entity);
        return toDto(entity);
    }
}
