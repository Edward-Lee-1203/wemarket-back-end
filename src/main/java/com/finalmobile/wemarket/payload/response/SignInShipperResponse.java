package com.finalmobile.wemarket.payload.response;

import com.finalmobile.wemarket.models.Shipper;

public class SignInShipperResponse {
    private String token;
    private String type = "Bearer";
    private Shipper shipper;

    public SignInShipperResponse(String token, Shipper shipper) {
        this.token = token;
        this.shipper = shipper;
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

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
}
