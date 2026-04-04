package com.example.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "amazon_url")
    private String amazonUrl;

    @Column(name = "amazon_price")
    private BigDecimal amazonPrice;

    @Column(name = "my_price")
    private BigDecimal myPrice;

    private BigDecimal profit;

    @Column(name = "shipping_charge")
    private BigDecimal shippingCharge;
}
