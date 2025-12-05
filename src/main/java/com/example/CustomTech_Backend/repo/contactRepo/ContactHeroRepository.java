package com.example.CustomTech_Backend.repo.contactRepo;

import com.example.CustomTech_Backend.entity.contactEntity.ContactHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactHeroRepository extends JpaRepository<ContactHero, Long> {
}
