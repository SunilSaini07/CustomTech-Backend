package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutHeroDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutHero;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutHeroRepository;
import com.example.CustomTech_Backend.service.aboutService.AboutHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutHeroServiceImpl implements AboutHeroService {

    @Autowired
    private AboutHeroRepository repo;

    @Override
    public AboutHeroDto getHero() {
        AboutHero hero = repo.findAll().stream().findFirst().orElse(null);
        if (hero == null) return null;

        AboutHeroDto dto = new AboutHeroDto();
        dto.setId(hero.getId());
        dto.setTitle(hero.getTitle());
        dto.setDescription(hero.getDescription());
        return dto;
    }

    @Override
    public AboutHeroDto updateHero(Long id, AboutHeroDto dto) {
        AboutHero hero = repo.findById(id).orElseThrow();

        hero.setTitle(dto.getTitle());
        hero.setDescription(dto.getDescription());

        repo.save(hero);

        dto.setId(hero.getId());
        return dto;
    }
}
