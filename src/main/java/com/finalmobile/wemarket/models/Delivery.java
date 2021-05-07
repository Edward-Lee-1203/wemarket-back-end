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
@NoArgsConstructor
@Getter
@Setter
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

}
