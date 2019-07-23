package com.rplsnapan.e_attendance.models;

public class LoginResponse {
    private  int status;
    private String message;
    private User user;

    public LoginResponse(int status, String message, User user) {
        this.status = status;
        this.message = message;
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
