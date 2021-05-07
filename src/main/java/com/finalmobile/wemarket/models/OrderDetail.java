package com.finalmobile.wemarket.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private  Integer product_id;

    @NotNull
    private  Integer order_id;

    @NotNull
    private  Integer kilogram;

    public OrderDetail(Integer id, @NotNull Integer product_id, @NotNull Integer order_id
            , @NotNull Integer kilogram) {
        this.id = id;
        this.product_id = product_id;
        this.order_id = order_id;
        this.kilogram = kilogram;
    }

    public OrderDetail(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getKilogram() {
        return kilogram;
    }

    public void setKilogram(Integer kilogram) {
        this.kilogram = kilogram;
    }
}
