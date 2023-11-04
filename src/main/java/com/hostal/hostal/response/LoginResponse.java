package com.hostal.hostal.response;

public class LoginResponse {
    private boolean authenticated;
    private String role;

    private Long userId;

    public LoginResponse(boolean authenticated, String role, Long userId) {
        this.authenticated = authenticated;
        this.role = role;
        this.userId = userId;
    }

    // Getters

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }
}