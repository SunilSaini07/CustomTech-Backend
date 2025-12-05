package com.example.CustomTech_Backend.service.ecommerceService;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceCoreDto;
import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceCore;
import com.example.CustomTech_Backend.repo.ecommerceRepo.EcommerceCoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcommerceCoreService {

    @Autowired
    private EcommerceCoreRepository repository;

    private EcommerceCoreDto toDto(EcommerceCore entity) {
        EcommerceCoreDto dto = new EcommerceCoreDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setFeatureText(entity.getFeatureText());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private EcommerceCore toEntity(EcommerceCoreDto dto) {
        EcommerceCore e = new EcommerceCore();
        e.setTitle(dto.getTitle());
        e.setFeatureText(dto.getFeatureText());
        return e;
    }

    public List<EcommerceCoreDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public EcommerceCoreDto create(EcommerceCoreDto dto) {
        EcommerceCore entity = toEntity(dto);
        entity = repository.save(entity);
        return toDto(entity);
    }

    public EcommerceCoreDto update(Long id, EcommerceCoreDto dto) throws Exception {
        EcommerceCore entity = repository.findById(id)
                .orElseThrow(() -> new Exception("EcommerceCore not found with id " + id));
        // update fields
        entity.setTitle(dto.getTitle());
        entity.setFeatureText(dto.getFeatureText());
        entity = repository.save(entity);
        return toDto(entity);
    }
}
