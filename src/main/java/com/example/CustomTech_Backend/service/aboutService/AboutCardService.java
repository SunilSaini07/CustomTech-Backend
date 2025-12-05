package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCardDto;

import java.util.List;

public interface AboutCardService {
    List<AboutCardDto> getAll();
    AboutCardDto update(Long id, AboutCardDto dto);
}
