package com.example.shoesapp.View.ui.login.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String password;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.password = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return password;
    }
}