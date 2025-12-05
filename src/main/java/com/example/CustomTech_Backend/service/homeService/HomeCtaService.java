package com.example.CustomTech_Backend.service.homeService;

import com.example.CustomTech_Backend.dto.homeDto.HomeCtaDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeCta;
import com.example.CustomTech_Backend.repo.homeRepo.HomeCtaRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeCtaService {

    private final HomeCtaRepository repository;

    public HomeCtaService(HomeCtaRepository repository) {
        this.repository = repository;
    }

    public HomeCtaDto getCta() {
        HomeCta cta = repository.findAll().stream().findFirst().orElse(null);

        if (cta == null) return null;

        HomeCtaDto dto = new HomeCtaDto();
        dto.setId(cta.getId());
        dto.setTitle(cta.getTitle());
        dto.setDescription(cta.getDescription());
        dto.setButtonText(cta.getButtonText());
        dto.setButtonLink(cta.getButtonLink());

        return dto;
    }

    public HomeCtaDto updateCta(Long id, HomeCtaDto dto) {
        HomeCta cta = repository.findById(id).orElseThrow();

        cta.setTitle(dto.getTitle());
        cta.setDescription(dto.getDescription());
        cta.setButtonText(dto.getButtonText());
        cta.setButtonLink(dto.getButtonLink());

        repository.save(cta);

        dto.setId(cta.getId());
        return dto;
    }
}
