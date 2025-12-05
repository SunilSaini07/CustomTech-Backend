package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesHeroDto;
import com.example.CustomTech_Backend.entity.industriesEntity.IndustriesHero;
import com.example.CustomTech_Backend.repo.industriesRepo.IndustriesHeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Transactional
public class IndustriesHeroServiceImpl implements IndustriesHeroService {

    private final IndustriesHeroRepository repo;

    public IndustriesHeroServiceImpl(IndustriesHeroRepository repo) {
        this.repo = repo;
    }

    @Override
    public IndustriesHeroDto getHero() {
        Optional<IndustriesHero> opt = repo.findTopByOrderByIdAsc();
        if (opt.isEmpty()) {
            return null;
        }
        IndustriesHero e = opt.get();
        return toDto(e);
    }

    @Override
    public IndustriesHeroDto updateHero(Long id, IndustriesHeroDto updateDto) {
        IndustriesHero hero = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found with id: " + id));

        if (updateDto.getTitle() != null) {
            hero.setTitle(updateDto.getTitle());
        }
        if (updateDto.getDescription() != null) {
            hero.setDescription(updateDto.getDescription());
        }

        IndustriesHero saved = repo.save(hero);
        return toDto(saved);
    }

    private IndustriesHeroDto toDto(IndustriesHero e) {
        String updatedAtStr = null;
        if (e.getUpdatedAt() != null) {
            updatedAtStr = e.getUpdatedAt().toInstant().toString();
        }
        return new IndustriesHeroDto(e.getId(), e.getTitle(), e.getDescription(), updatedAtStr);
    }
}
