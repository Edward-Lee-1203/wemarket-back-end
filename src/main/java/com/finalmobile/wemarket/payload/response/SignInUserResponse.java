package com.finalmobile.wemarket.payload.response;

import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.models.User;

public class SignInUserResponse {
    private String token;
    private String type = "Bearer";
    private User user;

    public SignInUserResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
