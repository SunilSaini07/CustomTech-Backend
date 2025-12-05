package com.example.CustomTech_Backend.repo.industriesRepo;

import com.example.CustomTech_Backend.entity.industriesEntity.IndustriesHero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndustriesHeroRepository extends JpaRepository<IndustriesHero, Long> {

    // return the first (top) hero row if there is one
    Optional<IndustriesHero> findTopByOrderByIdAsc();
}
