package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutHeroDto;

public interface AboutHeroService {
    AboutHeroDto getHero();
    AboutHeroDto updateHero(Long id, AboutHeroDto dto);
}
