package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndustriesDto;
import com.example.CustomTech_Backend.entity.industriesEntity.Industries;
import com.example.CustomTech_Backend.repo.industriesRepo.IndustriesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndustriesServiceImpl implements IndustriesService {

    private final IndustriesRepository repo;

    public IndustriesServiceImpl(IndustriesRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<IndustriesDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IndustriesDto getById(Integer id) {
        Industries ind = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Industry not found"));
        return toDto(ind);
    }

    @Override
    public IndustriesDto update(Integer id, IndustriesDto dto) {
        Industries ind = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Industry not found"));

        ind.setTitle(dto.getTitle());
        ind.setSubTitle(dto.getSubTitle());
        ind.setDescription(dto.getDescription());
        ind.setKeyTitle(dto.getKeyTitle());
        ind.setKeyText1(dto.getKeyText1());
        ind.setKeyText2(dto.getKeyText2());
        ind.setKeyText3(dto.getKeyText3());
        ind.setKeyText4(dto.getKeyText4());
        ind.setKeyText5(dto.getKeyText5());
        ind.setNote(dto.getNote());

        repo.save(ind);
        return toDto(ind);
    }

    private IndustriesDto toDto(Industries e) {
        IndustriesDto dto = new IndustriesDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setSubTitle(e.getSubTitle());
        dto.setDescription(e.getDescription());
        dto.setKeyTitle(e.getKeyTitle());
        dto.setKeyText1(e.getKeyText1());
        dto.setKeyText2(e.getKeyText2());
        dto.setKeyText3(e.getKeyText3());
        dto.setKeyText4(e.getKeyText4());
        dto.setKeyText5(e.getKeyText5());
        dto.setNote(e.getNote());

        return dto;
    }
}
