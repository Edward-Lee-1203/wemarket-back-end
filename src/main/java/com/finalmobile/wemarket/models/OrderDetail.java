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
    @ManyToOne
    @JoinColumn(name="product_id")
    private  Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name="order_id")
    private  Order orders;

    @NotNull
    private  Float kilogram;

    public OrderDetail(Integer id, @NotNull Product product, @NotNull Order order
            , @NotNull Float kilogram) {
        this.id = id;
        this.product = product;
        this.orders = order;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order order) {
        this.orders = order;
    }

    public Float getKilogram() {
        return kilogram;
    }

    public void setKilogram(Float kilogram) {
        this.kilogram = kilogram;
    }
}
