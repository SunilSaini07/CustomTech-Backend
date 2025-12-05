package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesDto;

import java.util.List;

public interface IndustriesService {

    List<IndustriesDto> getAll();
    IndustriesDto getById(Integer id);
    IndustriesDto update(Integer id, IndustriesDto dto);
}
