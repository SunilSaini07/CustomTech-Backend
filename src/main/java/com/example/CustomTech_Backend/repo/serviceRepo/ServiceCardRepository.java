package com.example.CustomTech_Backend.repo.serviceRepo;

import com.example.CustomTech_Backend.entity.serviceEntity.ServiceCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCardRepository extends JpaRepository<ServiceCard, Integer> {}
