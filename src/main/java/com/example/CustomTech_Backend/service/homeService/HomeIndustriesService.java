package com.example.CustomTech_Backend.service.homeService;


import com.example.CustomTech_Backend.dto.homeDto.HomeIndustriesDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeIndustries;
import com.example.CustomTech_Backend.repo.homeRepo.HomeIndustriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class HomeIndustriesService {


    @Autowired
    private HomeIndustriesRepository repository;


    private HomeIndustriesDto toDto(HomeIndustries e) {
        HomeIndustriesDto d = new HomeIndustriesDto();
        d.setId(e.getId());
        d.setMainTitle(e.getMainTitle());
        d.setTitle(e.getTitle());
        d.setDescription(e.getDescription());
        d.setKeyTitle(e.getKeyTitle());
        d.setKey1(e.getKey1());
        d.setKey2(e.getKey2());
        d.setKey3(e.getKey3());
        return d;
    }


    private HomeIndustries toEntity(HomeIndustriesDto d, HomeIndustries e) {
        if (d.getMainTitle() != null) e.setMainTitle(d.getMainTitle());
        if (d.getTitle() != null) e.setTitle(d.getTitle());
        if (d.getDescription() != null) e.setDescription(d.getDescription());
        if (d.getKeyTitle() != null) e.setKeyTitle(d.getKeyTitle());
        if (d.getKey1() != null) e.setKey1(d.getKey1());
        if (d.getKey2() != null) e.setKey2(d.getKey2());
        if (d.getKey3() != null) e.setKey3(d.getKey3());
        return e;
    }


    public List<HomeIndustriesDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }


    public Optional<HomeIndustriesDto> update(Integer id, HomeIndustriesDto dto) {
        Optional<HomeIndustries> existing = repository.findById(id);
        if (!existing.isPresent()) return Optional.empty();
        HomeIndustries ent = toEntity(dto, existing.get());
        HomeIndustries saved = repository.save(ent);
        return Optional.of(toDto(saved));
    }
}