package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCtaDto;

public interface SolutionsCtaService {

    SolutionsCtaDto getCta();
    SolutionsCtaDto updateCta(Integer id, SolutionsCtaDto dto);
}
