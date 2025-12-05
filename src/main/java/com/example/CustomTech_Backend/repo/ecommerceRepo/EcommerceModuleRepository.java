package com.example.CustomTech_Backend.repo.ecommerceRepo;

import com.example.CustomTech_Backend.entity.ecommerceEntity.EcommerceModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceModuleRepository extends JpaRepository<EcommerceModule, Long> {
}
