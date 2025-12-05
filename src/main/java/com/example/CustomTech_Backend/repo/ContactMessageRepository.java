package com.example.CustomTech_Backend.repo;

import com.example.CustomTech_Backend.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    Optional<ContactMessage> findByEmail(String email);
    boolean existsByEmail(String email);
}
