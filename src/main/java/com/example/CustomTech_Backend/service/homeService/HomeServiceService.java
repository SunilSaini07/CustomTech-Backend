package com.example.CustomTech_Backend.service.homeService;

import com.example.CustomTech_Backend.dto.homeDto.HomeServiceDto;
import com.example.CustomTech_Backend.entity.homeEntity.HomeService;
import com.example.CustomTech_Backend.repo.homeRepo.HomeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceService {

    @Autowired
    private HomeServiceRepository repo;

    public List<HomeService> getServices() {
        return repo.findAll();
    }

    public HomeService updateService(HomeServiceDto dto) {
        HomeService service = repo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        service.setTitle(dto.getTitle());
        service.setDescription(dto.getDescription());
        service.setServiceText(dto.getServiceText());

        return repo.save(service);
    }
}
