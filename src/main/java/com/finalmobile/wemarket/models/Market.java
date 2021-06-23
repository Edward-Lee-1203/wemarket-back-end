package com.finalmobile.wemarket.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 45)
    private  String name;

    @NotNull
    @Size(max = 45)
    private  String address;

    @NotNull
    private  Integer open_time;

    private  String longitude;

    private  String latitude;

    private Float itemsLeft;

    @NotNull
    private  Integer close_time;

    @NotBlank
    @Size(max = 45)
    private String market_type;

    @OneToMany(mappedBy = "market")
    private List<Product> products;

    public Market(Integer id, String name, String address, Integer open_time, String longitude, String latitude,
                  Float itemsLeft, Integer close_time, String market_type, List<Product> products) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.open_time = open_time;
        this.longitude = longitude;
        this.latitude = latitude;
        this.itemsLeft = itemsLeft;
        this.close_time = close_time;
        this.market_type = market_type;
        this.products = products;
    }

    public Market() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOpen_time() {
        return open_time;
    }

    public void setOpen_time(Integer open_time) {
        this.open_time = open_time;
    }

    public Integer getClose_time() {
        return close_time;
    }

    public void setClose_time(Integer close_time) {
        this.close_time = close_time;
    }

    public String getMarket_type() {
        return market_type;
    }

    public void setMarket_type(String market_type) {
        this.market_type = market_type;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Float getItemsLeft() {
        return itemsLeft;
    }

    public void setItemsLeft(Float itemsLeft) {
        this.itemsLeft = itemsLeft;
    }
}
