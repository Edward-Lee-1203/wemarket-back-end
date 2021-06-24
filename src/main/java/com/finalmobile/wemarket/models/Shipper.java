package com.finalmobile.wemarket.models;

import com.finalmobile.wemarket.models.enums.EDelivery;
import com.finalmobile.wemarket.models.enums.UserStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "shipper")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String phone;

    @NotBlank
    @Size(max = 20)
    private String username;

    private Float longitude;

    private  Float latitude;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EDelivery shipper_status;

    @NotBlank
    @Size(max = 120)
    private String password;

    @OneToOne(mappedBy = "shipper")
    private Delivery delivery;

    public Shipper() {
    }

    public Shipper(Long id, String name, String phone, String username, Float longitude, Float latitude,
                   String password, Delivery delivery) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.longitude = longitude;
        this.latitude = latitude;
        this.password = password;
        this.delivery = delivery;
    }

    public Shipper(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_SHIPPER");
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
