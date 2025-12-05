package com.example.CustomTech_Backend.service.serviceService;

import com.example.CustomTech_Backend.dto.serviceDto.ServiceCardDto;
import com.example.CustomTech_Backend.entity.serviceEntity.ServiceCard;
import com.example.CustomTech_Backend.repo.serviceRepo.ServiceCardRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCardServiceImpl implements ServiceCardService {

    private final ServiceCardRepository repo;

    public ServiceCardServiceImpl(ServiceCardRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ServiceCardDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceCardDto getById(Integer id) {
        ServiceCard card = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service card not found"));
        return toDto(card);
    }

    @Override
    public ServiceCardDto update(Integer id, ServiceCardDto dto) {
        ServiceCard card = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service card not found"));

        card.setTitle(dto.getTitle());
        card.setDescription(dto.getDescription());
        card.setFeature_1(dto.getFeature_1());
        card.setFeature_2(dto.getFeature_2());
        card.setFeature_3(dto.getFeature_3());
        card.setFeature_4(dto.getFeature_4());
        card.setButtonText(dto.getButtonText());
        card.setButtonLink(dto.getButtonLink());

        repo.save(card);
        return toDto(card);
    }

    private ServiceCardDto toDto(ServiceCard e) {
        ServiceCardDto dto = new ServiceCardDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setFeature_1(e.getFeature_1());
        dto.setFeature_2(e.getFeature_2());
        dto.setFeature_3(e.getFeature_3());
        dto.setFeature_4(e.getFeature_4());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());

        return dto;
    }
}
