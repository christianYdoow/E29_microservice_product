package com.lazMalling.product.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name="product_description")
    private String productDescription;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name="product_category")
    private String productCategory;

    @Column(name = "product_user_id")
    private long userId;




}
