package com.finalmobile.wemarket.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private  Integer market_id;

    @NotBlank
    @Size(max = 45)
    private String product_type;

    public Product(Integer id, @NotNull @Size(max = 45) String name, @NotNull Integer price,
                   @NotNull Integer market_id, @NotBlank @Size(max = 45) String product_type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.market_id = market_id;
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

    public Integer getMarket_id() {
        return market_id;
    }

    public void setMarket_id(Integer market_id) {
        this.market_id = market_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
