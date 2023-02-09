package com.lazMalling.product.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name="product_description")
    private String productDescription;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name="product_category")
    private String productCategory;

    @Column(name = "product_userId")
    private long userId;




}
