package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCtaDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutCta;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutCtaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutCtaServiceImpl implements AboutCtaService {

    private final AboutCtaRepository repo;

    public AboutCtaServiceImpl(AboutCtaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<AboutCtaDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AboutCtaDto getById(Long id) {
        AboutCta entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));
        return toDto(entity);
    }

    @Override
    public AboutCtaDto create(AboutCtaDto dto) {
        AboutCta entity = new AboutCta();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setButtonText(dto.getButtonText());
        entity.setButtonLink(dto.getButtonLink());

        AboutCta saved = repo.save(entity);
        return toDto(saved);
    }

    @Override
    public AboutCtaDto update(Long id, AboutCtaDto dto) {
        AboutCta entity = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        if (dto.getTitle() != null) entity.setTitle(dto.getTitle());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getButtonText() != null) entity.setButtonText(dto.getButtonText());
        if (dto.getButtonLink() != null) entity.setButtonLink(dto.getButtonLink());

        AboutCta saved = repo.save(entity);
        return toDto(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found");
        }
        repo.deleteById(id);
    }

    private AboutCtaDto toDto(AboutCta e) {
        AboutCtaDto dto = new AboutCtaDto();
        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());
        return dto;
    }
}
