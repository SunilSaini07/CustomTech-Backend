package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCtaDto;

public interface ServiceCtaService {

    ServiceCtaDto getCta();
    ServiceCtaDto updateCta(Integer id, ServiceCtaDto dto);
}
