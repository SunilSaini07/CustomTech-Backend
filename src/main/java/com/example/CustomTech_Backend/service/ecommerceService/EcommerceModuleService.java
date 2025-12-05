package com.example.CustomTech_Backend.service.ecommerceService;

import com.example.CustomTech_Backend.dto.ecommerceDto.EcommerceModuleDto;
import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceModule;
import com.example.CustomTech_Backend.repo.ecommerceRepo.EcommerceModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcommerceModuleService {

    @Autowired
    private EcommerceModuleRepository repository;

    private EcommerceModuleDto toDto(EcommerceModule entity) {
        EcommerceModuleDto dto = new EcommerceModuleDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setModuleText(entity.getModuleText());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private EcommerceModule toEntity(EcommerceModuleDto dto) {
        EcommerceModule e = new EcommerceModule();
        e.setTitle(dto.getTitle());
        e.setModuleText(dto.getModuleText());
        return e;
    }

    public List<EcommerceModuleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public EcommerceModuleDto create(EcommerceModuleDto dto) {
        EcommerceModule entity = toEntity(dto);
        entity = repository.save(entity);
        return toDto(entity);
    }

    public EcommerceModuleDto update(Long id, EcommerceModuleDto dto) throws Exception {
        EcommerceModule entity = repository.findById(id)
                .orElseThrow(() -> new Exception("EcommerceModule not found with id " + id));
        entity.setTitle(dto.getTitle());
        entity.setModuleText(dto.getModuleText());
        entity = repository.save(entity);
        return toDto(entity);
    }
}
