package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCardDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutCard;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutCardRepository;
import com.example.CustomTech_Backend.service.aboutService.AboutCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutCardServiceImpl implements AboutCardService {

    private final AboutCardRepository repository;

    public AboutCardServiceImpl(AboutCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AboutCardDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AboutCardDto update(Long id, AboutCardDto dto) {
        AboutCard card = repository.findById(id).orElseThrow();

        card.setTitle(dto.getTitle());
        card.setDescription(dto.getDescription());
        card.setIcon(dto.getIcon());

        repository.save(card);

        return toDto(card);
    }

    private AboutCardDto toDto(AboutCard card) {
        AboutCardDto dto = new AboutCardDto();
        dto.setId(card.getId());
        dto.setTitle(card.getTitle());
        dto.setDescription(card.getDescription());
        dto.setIcon(card.getIcon());
        return dto;
    }
}
