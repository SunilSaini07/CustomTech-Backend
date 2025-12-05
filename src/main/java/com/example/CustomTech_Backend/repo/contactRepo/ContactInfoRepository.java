package com.example.CustomTech_Backend.repo.contactRepo;

import com.example.CustomTech_Backend.entity.contactEntity.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
