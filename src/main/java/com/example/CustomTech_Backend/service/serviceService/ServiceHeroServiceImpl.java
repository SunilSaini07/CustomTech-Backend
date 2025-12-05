package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceHeroDto;
import com.example.CustomTech_Backend.entity.serviceEntity.ServiceHero;
import com.example.CustomTech_Backend.repo.serviceRepo.ServiceHeroRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceHeroServiceImpl implements ServiceHeroService {

    private final ServiceHeroRepository repo;

    public ServiceHeroServiceImpl(ServiceHeroRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ServiceHeroDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceHeroDto getById(Integer id) {
        ServiceHero hero = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found"));
        return toDto(hero);
    }

    @Override
    public ServiceHeroDto update(Integer id, ServiceHeroDto dto) {
        ServiceHero hero = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hero not found"));

        hero.setTitle(dto.getTitle());
        hero.setDescription(dto.getDescription());

        repo.save(hero);
        return toDto(hero);
    }

    private ServiceHeroDto toDto(ServiceHero e) {
        ServiceHeroDto dto = new ServiceHeroDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());

        return dto;
    }
}
