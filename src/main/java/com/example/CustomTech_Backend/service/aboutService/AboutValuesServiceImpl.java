package com.example.CustomTech_Backend.service.aboutService;

import com.example.CustomTech_Backend.dto.aboutDto.AboutValuesDto;
import com.example.CustomTech_Backend.entity.aboutEntity.AboutValuesEntity;
import com.example.CustomTech_Backend.repo.aboutRepo.AboutValuesRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutValuesServiceImpl implements AboutValuesService {

    private final AboutValuesRepository repo;

    public AboutValuesServiceImpl(AboutValuesRepository repo) {
        this.repo = repo;
    }

    @Override
    public AboutValuesEntity getValues() {
        return repo.findById(1L).orElse(null);
    }

    @Override
    public AboutValuesEntity updateValues(Long id, AboutValuesDto dto) {
        AboutValuesEntity data = repo.findById(id).orElseThrow();

        data.setTitle(dto.getTitle());
        data.setDescription(dto.getDescription());

        return repo.save(data);
    }
}
