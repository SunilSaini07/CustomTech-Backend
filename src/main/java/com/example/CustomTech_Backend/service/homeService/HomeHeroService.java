package com.example.CustomTech_Backend.service.homeService;

import com.example.CustomTech_Backend.dto.homeDto.HomeHeroDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeHero;
import com.example.CustomTech_Backend.repo.homeRepo.HomeHeroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Service
public class HomeHeroService {

    private final HomeHeroRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public HomeHeroService(HomeHeroRepository repo) {
        this.repo = repo;
    }

    public HomeHeroDto getHero() {
        HomeHero hero = repo.findTopByOrderByIdAsc().orElse(null);
        if (hero == null) return null;

        HomeHeroDto dto = new HomeHeroDto();
        dto.id = hero.getId();
        dto.title = hero.getTitle();
        dto.subtitle = hero.getSubtitle();
        dto.ctaText = hero.getCtaText();
        dto.ctaUrl = hero.getCtaUrl();
        dto.backgroundImage = hero.getBackgroundImage();


        if (hero.getUpdatedAt() != null) {
            dto.updatedAt = hero.getUpdatedAt()
                    .atOffset(ZoneOffset.UTC)
                    .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }
        return dto;
    }

    public HomeHeroDto updateHero(HomeHeroDto incoming) throws Exception {
        HomeHero hero = repo.findTopByOrderByIdAsc().orElse(new HomeHero());

        hero.setTitle(incoming.title);
        hero.setSubtitle(incoming.subtitle);
        hero.setCtaText(incoming.ctaText);
        hero.setCtaUrl(incoming.ctaUrl);
        hero.setBackgroundImage(incoming.backgroundImage);

        repo.save(hero);
        return getHero();
    }
}
