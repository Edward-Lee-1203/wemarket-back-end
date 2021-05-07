package com.finalmobile.wemarket.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

    @NotNull
    private  Integer close_time;

    @NotBlank
    @Size(max = 45)
    private String market_type;
}
