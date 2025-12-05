package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesHeroDto;

public interface IndustriesHeroService {

    /**
     * Return the hero DTO (the top/first row in ind_hero).
     * If no row exists, returns null.
     */
    IndustriesHeroDto getHero();

    /**
     * Update the hero row by id. Returns updated DTO.
     * Throws RuntimeException (or a Spring exception) if not found.
     */
    IndustriesHeroDto updateHero(Long id, IndustriesHeroDto updateDto);
}
