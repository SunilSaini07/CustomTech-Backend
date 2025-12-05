package com.example.CustomTech_Backend.repo.contactRepo;

import com.example.CustomTech_Backend.entity.contactEntity.ContactAbout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactAboutRepository extends JpaRepository<ContactAbout, Long> {
}
