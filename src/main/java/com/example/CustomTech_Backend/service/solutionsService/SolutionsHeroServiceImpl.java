package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsHeroDto;
import com.example.CustomTech_Backend.entity.solutionsEntity.SolutionsHero;
import com.example.CustomTech_Backend.repo.solutionsRepo.SolutionsHeroRepository;
import com.example.CustomTech_Backend.service.solutionsService.SolutionsHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionsHeroServiceImpl implements SolutionsHeroService {

    @Autowired
    private SolutionsHeroRepository repo;

    @Override
    public SolutionsHeroDto getHero() {
        SolutionsHero hero = repo.findAll().stream().findFirst().orElse(null);
        if (hero == null) return null;

        SolutionsHeroDto dto = new SolutionsHeroDto();
        dto.setId(hero.getId());
        dto.setTitle(hero.getTitle());
        dto.setDescription(hero.getDescription());
        return dto;
    }

    @Override
    public SolutionsHeroDto updateHero(Long id, SolutionsHeroDto dto) {
        SolutionsHero hero = repo.findById(id).orElseThrow();

        hero.setTitle(dto.getTitle());
        hero.setDescription(dto.getDescription());

        repo.save(hero);

        dto.setId(hero.getId());
        return dto;
    }
}
