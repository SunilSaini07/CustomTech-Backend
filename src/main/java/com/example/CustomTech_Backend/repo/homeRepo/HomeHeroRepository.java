package com.example.CustomTech_Backend.repo.homeRepo;

import com.example.CustomTech_Backend.entity.homeEntity.HomeHero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HomeHeroRepository extends JpaRepository<HomeHero, Long> {
    Optional<HomeHero> findTopByOrderByIdAsc(); // default hero record
}
