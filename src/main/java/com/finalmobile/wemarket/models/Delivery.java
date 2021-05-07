package com.finalmobile.wemarket.models;


import com.finalmobile.wemarket.models.enums.EDelivery;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orders;

    @NotNull
    private Integer timeLimit;

    @NotBlank
    @Size(max = 70)
    private String address;

    @NotBlank
    private String date;

    @NotNull
    private Integer is_confirm;

    @NotNull
    private Integer is_keep_social;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EDelivery delivery;

    public Delivery(Integer id, @NotNull Shipper shipper, @NotNull User user, @NotNull Order orders
            , @NotNull Integer timeLimit, @NotBlank @Size(max = 70) String address, @NotBlank String date
            , @NotNull Integer is_confirm, @NotNull Integer is_keep_social, @NotBlank EDelivery delivery) {
        this.id = id;
        this.shipper = shipper;
        this.user = user;
        this.orders = orders;
        this.timeLimit = timeLimit;
        this.address = address;
        this.date = date;
        this.is_confirm = is_confirm;
        this.is_keep_social = is_keep_social;
        this.delivery = delivery;
    }

    public Delivery() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public User getUser() {
        return user;
    }

    public void setUser_id(User user) {
        this.user = user;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIs_confirm() {
        return is_confirm;
    }

    public void setIs_confirm(Integer is_confirm) {
        this.is_confirm = is_confirm;
    }

    public Integer getIs_keep_social() {
        return is_keep_social;
    }

    public void setIs_keep_social(Integer is_keep_social) {
        this.is_keep_social = is_keep_social;
    }

    public EDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(EDelivery delivery) {
        this.delivery = delivery;
    }
}
