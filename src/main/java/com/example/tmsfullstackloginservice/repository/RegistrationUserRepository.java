package com.example.tmsfullstackloginservice.repository;

import com.example.tmsfullstackloginservice.entity.RegistrationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationUserRepository
        extends JpaRepository<RegistrationUserEntity, Long> {

    boolean existsByUserId(String userId);
}