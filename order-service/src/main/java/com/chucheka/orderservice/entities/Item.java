package com.chucheka.orderservice.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long name;

    private Integer quantity;

    private Double amount;

    private String restaurantCode;

}
