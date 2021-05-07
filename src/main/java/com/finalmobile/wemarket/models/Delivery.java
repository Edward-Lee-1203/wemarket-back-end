package com.finalmobile.wemarket.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer shipper_id;

    @NotNull
    private Integer user_id;

    @NotNull
    private Integer order_id;

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
    private Integer is_keepsocial;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private EDelivery delivery;

    public Delivery(Integer id, @NotNull Integer shipper_id, @NotNull Integer user_id, @NotNull Integer order_id, @NotNull Integer timeLimit, @NotBlank @Size(max = 70) String address, @NotBlank String date
            , @NotNull Integer is_confirm, @NotNull Integer is_keepsocial, @NotBlank EDelivery delivery) {
        this.id = id;
        this.shipper_id = shipper_id;
        this.user_id = user_id;
        this.order_id = order_id;
        this.timeLimit = timeLimit;
        this.address = address;
        this.date = date;
        this.is_confirm = is_confirm;
        this.is_keepsocial = is_keepsocial;
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

    public Integer getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(Integer shipper_id) {
        this.shipper_id = shipper_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

    public Integer getIs_keepsocial() {
        return is_keepsocial;
    }

    public void setIs_keepsocial(Integer is_keepsocial) {
        this.is_keepsocial = is_keepsocial;
    }

    public EDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(EDelivery delivery) {
        this.delivery = delivery;
    }
}
