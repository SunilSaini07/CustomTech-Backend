package com.example.CustomTech_Backend.repo.ecommerceRepo;

import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceHeroRepository extends JpaRepository<EcommerceHero, Long> {
}
