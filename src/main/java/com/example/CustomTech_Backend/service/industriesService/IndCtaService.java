package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndCtaDto;

import java.util.List;

public interface IndCtaService {

    List<IndCtaDto> getAll();
    IndCtaDto getById(Integer id);
    IndCtaDto update(Integer id, IndCtaDto dto);
}
