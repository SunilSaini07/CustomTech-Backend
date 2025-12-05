package com.example.CustomTech_Backend.repo.homeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CustomTech_Backend.entity.homeEntity.HomeService;

public interface HomeServiceRepository extends JpaRepository<HomeService, Long> {
}
