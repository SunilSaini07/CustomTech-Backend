package com.example.CustomTech_Backend.repo.ecommerceRepo;

import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceCore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceCoreRepository extends JpaRepository<EcommerceCore, Long> {
}
