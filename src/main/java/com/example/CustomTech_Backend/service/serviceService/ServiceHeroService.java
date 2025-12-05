package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceHeroDto;
import java.util.List;

public interface ServiceHeroService {

    List<ServiceHeroDto> getAll();
    ServiceHeroDto getById(Integer id);
    ServiceHeroDto update(Integer id, ServiceHeroDto dto);
}
