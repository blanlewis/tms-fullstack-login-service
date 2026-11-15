package com.example.tmsfullstackloginservice.controller;

import com.example.tmsfullstackloginservice.service.LoginService;
import com.example.tmsfullstackloginservice.service.LoginService.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final HttpServletRequest request;

    public LoginController(
            LoginService loginService,
            HttpServletRequest request
    ) {
        this.loginService = loginService;
        this.request = request;
    }

    @QueryMapping
    public LoginResponse login(
            @Argument String userId,
            @Argument String password
    ) {
        return loginService.login(
                userId,
                password,
                request.getSession()
        );
    }

    @QueryMapping
    public LoginResponse currentUser() {
        return loginService.currentUser(request.getSession());
    }
}