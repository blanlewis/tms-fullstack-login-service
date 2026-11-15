package com.example.tmsfullstackloginservice.service;

import com.example.tmsfullstackloginservice.entity.RegistrationUserEntity;
import com.example.tmsfullstackloginservice.repository.RegistrationUserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final RegistrationUserRepository registrationUserRepository;

    public RegistrationService(
            RegistrationUserRepository registrationUserRepository
    ) {
        this.registrationUserRepository = registrationUserRepository;
    }

    public RegistrationResponse registerUser(
            String userId,
            String password
    ) {

        // Check whether the user ID already exists
        if (registrationUserRepository.existsByUserId(userId)) {
            return new RegistrationResponse(null, false);
        }

        // Create a new user
        RegistrationUserEntity user = new RegistrationUserEntity();

        user.setUserId(userId);
        user.setPassword(password);

        // Store the new user in PostgreSQL
        RegistrationUserEntity savedUser =
                registrationUserRepository.save(user);

        // Return registration response
        return new RegistrationResponse(
                savedUser.getUserId(),
                true
        );
    }

    public record RegistrationResponse(
            String userId,
            boolean isStoredSuccessfully
    ) {
    }
}