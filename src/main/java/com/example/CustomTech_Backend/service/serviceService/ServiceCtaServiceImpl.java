package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCtaDto;
import com.example.CustomTech_Backend.entity.serviceEntity.ServiceCta;
import com.example.CustomTech_Backend.repo.serviceRepo.ServiceCtaRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceCtaServiceImpl implements ServiceCtaService {

    private final ServiceCtaRepository repo;

    public ServiceCtaServiceImpl(ServiceCtaRepository repo) {
        this.repo = repo;
    }

    @Override
    public ServiceCtaDto getCta() {
        ServiceCta cta = repo.findAll().stream().findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        return toDto(cta);
    }

    @Override
    public ServiceCtaDto updateCta(Integer id, ServiceCtaDto dto) {
        ServiceCta cta = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CTA not found"));

        cta.setTitle(dto.getTitle());
        cta.setDescription(dto.getDescription());
        cta.setButtonText(dto.getButtonText());
        cta.setButtonLink(dto.getButtonLink());

        repo.save(cta);

        return toDto(cta);
    }

    private ServiceCtaDto toDto(ServiceCta e) {
        ServiceCtaDto dto = new ServiceCtaDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());

        return dto;
    }
}
