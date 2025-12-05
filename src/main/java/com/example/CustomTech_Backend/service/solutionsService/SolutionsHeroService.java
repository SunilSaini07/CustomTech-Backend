package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsHeroDto;

public interface SolutionsHeroService {
    SolutionsHeroDto getHero();
    SolutionsHeroDto updateHero(Long id, SolutionsHeroDto dto);
}
