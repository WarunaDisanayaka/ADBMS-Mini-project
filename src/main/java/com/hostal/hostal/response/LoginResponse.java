package com.hostal.hostal.response;

public class LoginResponse {
    private boolean authenticated;
    private String role;

    public LoginResponse(boolean authenticated, String role) {
        this.authenticated = authenticated;
        this.role = role;
    }

    // Getters

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getRole() {
        return role;
    }
}