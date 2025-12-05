package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCardDto;

import java.util.List;

public interface ServiceCardService {

    List<ServiceCardDto> getAll();
    ServiceCardDto getById(Integer id);
    ServiceCardDto update(Integer id, ServiceCardDto dto);
}
