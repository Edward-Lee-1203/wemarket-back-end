package com.finalmobile.wemarket.models;

import com.finalmobile.wemarket.models.enums.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(	name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 70)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String phone;

    private Float longitude;

    private  Float latitude;

    @NotNull
    private int gender;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserStatus user_status;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password, String name, String phone, Float longitude, Float latitude,
                int gender, UserStatus user_status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.gender = gender;
        this.user_status = user_status;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public UserStatus getUser_status() {
        return user_status;
    }

    public void setUser_status(UserStatus user_status) {
        this.user_status = user_status;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        return roles;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
