package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndCardDto;

import java.util.List;

public interface IndCardService {

    List<IndCardDto> getAll();
    IndCardDto getById(Integer id);
    IndCardDto update(Integer id, IndCardDto dto);
}
