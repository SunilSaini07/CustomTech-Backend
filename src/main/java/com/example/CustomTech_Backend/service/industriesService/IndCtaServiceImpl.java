package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndCtaDto;
import com.example.CustomTech_Backend.entity.industriesEntity.IndCta;
import com.example.CustomTech_Backend.repo.industriesRepo.IndCtaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndCtaServiceImpl implements IndCtaService {

    private final IndCtaRepository repo;

    public IndCtaServiceImpl(IndCtaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<IndCtaDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IndCtaDto getById(Integer id) {
        IndCta cta = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));
        return toDto(cta);
    }

    @Override
    public IndCtaDto update(Integer id, IndCtaDto dto) {
        IndCta cta = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        cta.setTitle(dto.getTitle());
        cta.setDescription(dto.getDescription());
        cta.setButtonText(dto.getButtonText());
        cta.setButtonLink(dto.getButtonLink());

        repo.save(cta);
        return toDto(cta);
    }

    private IndCtaDto toDto(IndCta e) {
        IndCtaDto dto = new IndCtaDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());

        return dto;
    }
}
