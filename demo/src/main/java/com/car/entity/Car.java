package com.car.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String model;
    private String year;
}
