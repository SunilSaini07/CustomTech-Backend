package com.example.CustomTech_Backend.service.industriesService;

import com.example.CustomTech_Backend.dto.industriesDto.IndCardDto;
import com.example.CustomTech_Backend.entity.industriesEntity.IndCard;
import com.example.CustomTech_Backend.repo.industriesRepo.IndCardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndCardServiceImpl implements IndCardService {

    private final IndCardRepository repo;

    public IndCardServiceImpl(IndCardRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<IndCardDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IndCardDto getById(Integer id) {
        IndCard card = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found"));
        return toDto(card);
    }

    @Override
    public IndCardDto update(Integer id, IndCardDto dto) {
        IndCard card = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found"));

        card.setTitle(dto.getTitle());
        card.setDescription(dto.getDescription());
        card.setButtonText(dto.getButtonText());
        card.setButtonLink(dto.getButtonLink());

        repo.save(card);
        return toDto(card);
    }

    private IndCardDto toDto(IndCard e) {
        IndCardDto dto = new IndCardDto();

        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setDescription(e.getDescription());
        dto.setButtonText(e.getButtonText());
        dto.setButtonLink(e.getButtonLink());

        return dto;
    }
}
