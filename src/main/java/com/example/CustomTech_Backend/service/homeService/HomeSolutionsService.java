package com.example.CustomTech_Backend.service.homeService;

import com.example.CustomTech_Backend.dto.homeDto.HomeSolutionsDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeSolutions;
import com.example.CustomTech_Backend.repo.homeRepo.HomeSolutionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeSolutionsService {

    private final HomeSolutionsRepository repository;

    public HomeSolutionsService(HomeSolutionsRepository repository) {
        this.repository = repository;
    }

    public List<HomeSolutionsDto> getAllSolutions() {
        return repository.findAll().stream()
                .map(sol -> {
                    HomeSolutionsDto dto = new HomeSolutionsDto();
                    dto.setId(sol.getId());
                    dto.setMainTitle(sol.getMainTitle());
                    dto.setTitle(sol.getTitle());
                    dto.setDescription(sol.getDescription());
                    return dto;
                }).collect(Collectors.toList());
    }

    public HomeSolutionsDto updateSolution(Long id, HomeSolutionsDto dto) {
        HomeSolutions sol = repository.findById(id).orElseThrow();

        sol.setMainTitle(dto.getMainTitle());
        sol.setTitle(dto.getTitle());
        sol.setDescription(dto.getDescription());

        repository.save(sol);

        dto.setId(sol.getId());
        return dto;
    }
}
