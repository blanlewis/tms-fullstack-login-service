package com.example.tmsfullstackloginservice.controller;

import com.example.tmsfullstackloginservice.service.RegistrationService;
import com.example.tmsfullstackloginservice.service.RegistrationService.RegistrationResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @MutationMapping
    public RegistrationResponse registerUser(
            @Argument String userId,
            @Argument String password
    ) {
        return registrationService.registerUser(userId, password);
    }
}