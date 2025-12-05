package com.example.CustomTech_Backend.service.solutionsService;

import com.example.CustomTech_Backend.dto.solutionsDto.SolutionsCardDto;
import java.util.List;

public interface SolutionsCardService {

    List<SolutionsCardDto> getAllCards();
    SolutionsCardDto getCardById(Long id);
    SolutionsCardDto updateCard(Long id, SolutionsCardDto dto);
}
