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
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 45)
    private  String name;

    @NotNull
    private  Integer price;

    @NotNull
    @OneToOne
    @JoinColumn(name = "market_id")
    private  Market market;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @NotBlank
    @Size(max = 45)
    private String product_type;

    public Product(Integer id, @NotNull @Size(max = 45) String name, @NotNull Integer price,
                   @NotNull Market market, @NotBlank @Size(max = 45) String product_type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.market = market;
        this.product_type = product_type;
    }

    public Product(){

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
