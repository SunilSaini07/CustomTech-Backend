package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutMissionDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutMissionEntity;

public interface AboutMissionService {

    AboutMissionEntity getMission();

    AboutMissionEntity updateMission(Long id, AboutMissionDto dto);
}
