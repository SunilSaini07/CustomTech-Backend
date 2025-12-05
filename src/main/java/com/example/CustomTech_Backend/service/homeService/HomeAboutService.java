package com.example.CustomTech_Backend.service.homeService;

import com.example.CustomTech_Backend.entity.homeEntity.HomeAbout;
import com.example.CustomTech_Backend.repo.homeRepo.HomeAboutRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeAboutService {

    private final HomeAboutRepository repo;

    public HomeAboutService(HomeAboutRepository repo) {
        this.repo = repo;
    }

    public HomeAbout getAbout() {
        return repo.findById(1L).orElse(null); // Only one row
    }

    public HomeAbout updateAbout(HomeAbout updated) {
        updated.setId(1L); // forced single row update
        return repo.save(updated);
    }
}
