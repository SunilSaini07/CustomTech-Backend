package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutValuesDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutValuesEntity;

public interface AboutValuesService {

    AboutValuesEntity getValues();

    AboutValuesEntity updateValues(Long id, AboutValuesDto dto);
}
