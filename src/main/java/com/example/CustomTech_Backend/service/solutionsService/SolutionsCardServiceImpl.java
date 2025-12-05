package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCardDto;
import com.example.CustomTech_Backend.entity.solutionsEntity.SolutionsCard;
import com.example.CustomTech_Backend.repo.solutionsRepo.SolutionsCardRepository;
import com.example.CustomTech_Backend.service.solutionsService.SolutionsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolutionsCardServiceImpl implements SolutionsCardService {

    @Autowired
    private SolutionsCardRepository repo;

    private SolutionsCardDto convertToDto(SolutionsCard card) {
        SolutionsCardDto dto = new SolutionsCardDto();
        dto.setId(card.getId());
        dto.setTitle(card.getTitle());
        dto.setDescription(card.getDescription());
        dto.setImageUrl(card.getImageUrl());
        dto.setBgGradient(card.getBgGradient());
        return dto;
    }

    @Override
    public List<SolutionsCardDto> getAllCards() {
        return repo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SolutionsCardDto getCardById(Long id) {
        SolutionsCard card = repo.findById(id).orElseThrow();
        return convertToDto(card);
    }

    @Override
    public SolutionsCardDto updateCard(Long id, SolutionsCardDto dto) {
        SolutionsCard card = repo.findById(id).orElseThrow();

        card.setTitle(dto.getTitle());
        card.setDescription(dto.getDescription());
        card.setImageUrl(dto.getImageUrl());
        card.setBgGradient(dto.getBgGradient());

        repo.save(card);

        return convertToDto(card);
    }
}
