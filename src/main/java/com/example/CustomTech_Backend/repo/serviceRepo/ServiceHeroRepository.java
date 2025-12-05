package com.example.CustomTech_Backend.repo.serviceRepo;

import com.example.CustomTech_Backend.entity.serviceEntity.ServiceHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceHeroRepository extends JpaRepository<ServiceHero, Integer> {

}
