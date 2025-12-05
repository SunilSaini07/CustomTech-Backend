package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCtaDto;
import com.example.CustomTech_Backend.entity.solutionsEntity.SolutionsCta;
import com.example.CustomTech_Backend.repo.solutionsRepo.SolutionsCtaRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SolutionsCtaServiceImpl implements SolutionsCtaService {

    private final SolutionsCtaRepository repo;

    public SolutionsCtaServiceImpl(SolutionsCtaRepository repo) {
        this.repo = repo;
    }

    @Override
    public SolutionsCtaDto getCta() {
        SolutionsCta cta = repo.findAll().stream().findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        return toDto(cta);
    }

    @Override
    public SolutionsCtaDto updateCta(Integer id, SolutionsCtaDto dto) {
        SolutionsCta cta = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        cta.setTitle(dto.getTitle());
        cta.setDescription(dto.getDescription());
        cta.setButtonText(dto.getButtonText());
        cta.setButtonLink(dto.getButtonLink());

        repo.save(cta);

        return toDto(cta);
    }

    private SolutionsCtaDto toDto(SolutionsCta e) {
        SolutionsCtaDto dto = new SolutionsCtaDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());

        return dto;
    }
}
