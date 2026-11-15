package com.example.tmsfullstackloginservice.service;

import com.example.tmsfullstackloginservice.entity.LoginUserEntity;
import com.example.tmsfullstackloginservice.repository.LoginUserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginUserRepository loginUserRepository;

    public LoginService(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    public LoginResponse login(
            String userId,
            String password,
            HttpSession session
    ) {
        LoginUserEntity user = loginUserRepository
                .findByUserIdAndPassword(userId, password)
                .orElse(null);

        if (user == null) {
            session.removeAttribute("LOGIN_USER_ID");
            return new LoginResponse(null, false);
        }

        session.setAttribute("LOGIN_USER_ID", user.getUserId());

        return new LoginResponse(user.getUserId(), true);
    }

    public LoginResponse currentUser(HttpSession session) {
        String userId = (String) session.getAttribute("LOGIN_USER_ID");

        if (userId == null) {
            return new LoginResponse(null, false);
        }

        return loginUserRepository.findByUserId(userId)
                .map(user -> new LoginResponse(user.getUserId(), true))
                .orElse(new LoginResponse(null, false));
    }

    public record LoginResponse(
            String userId,
            boolean isLoggedIn
    ) {
    }
}