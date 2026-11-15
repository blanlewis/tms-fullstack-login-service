package com.example.tmsfullstackloginservice.repository;

import com.example.tmsfullstackloginservice.entity.LoginUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository
        extends JpaRepository<LoginUserEntity, Long> {

    Optional<LoginUserEntity> findByUserIdAndPassword(
            String userId,
            String password
    );

    Optional<LoginUserEntity> findByUserId(String userId);
}