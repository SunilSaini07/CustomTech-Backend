package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutCtaDto;
import java.util.List;

public interface AboutCtaService {

    List<AboutCtaDto> getAll();
    AboutCtaDto getById(Long id);
    AboutCtaDto create(AboutCtaDto dto);
    AboutCtaDto update(Long id, AboutCtaDto dto);
    void delete(Long id);
}