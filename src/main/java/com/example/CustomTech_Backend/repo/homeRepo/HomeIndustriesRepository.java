package com.example.CustomTech_Backend.repo.homeRepo;


import com.example.CustomTech_Backend.entity.homeEntity.HomeIndustries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomeIndustriesRepository extends JpaRepository<HomeIndustries, Integer> {
}