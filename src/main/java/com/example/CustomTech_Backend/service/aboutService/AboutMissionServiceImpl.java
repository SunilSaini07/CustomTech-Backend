package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutMissionDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutMissionEntity;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutHeroRepository;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutMissionRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutMissionServiceImpl implements AboutMissionService {

    private final AboutMissionRepository repo;

    public AboutMissionServiceImpl(AboutMissionRepository repo) {
        this.repo = repo;
    }

    @Override
    public AboutMissionEntity getMission() {
        return repo.findById(1L).orElse(null);
    }

    @Override
    public AboutMissionEntity updateMission(Long id, AboutMissionDto dto) {
        AboutMissionEntity data = repo.findById(id).orElseThrow();

        data.setTitle(dto.getTitle());
        data.setDescription1(dto.getDescription1());
        data.setDescription2(dto.getDescription2());
        data.setImageUrl(dto.getImageUrl());
        data.setButtonText(dto.getButtonText());
        data.setButtonLink(dto.getButtonLink());

        return repo.save(data);
    }
}
