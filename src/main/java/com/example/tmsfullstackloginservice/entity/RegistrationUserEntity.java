package com.example.tmsfullstackloginservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tms_fullstack_login_user_entity")
public class RegistrationUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}