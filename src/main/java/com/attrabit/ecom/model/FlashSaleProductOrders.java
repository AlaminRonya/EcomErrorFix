package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "flash_sale_product_orders")
@Data
public class FlashSaleProductOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("flashSaleProductId")
    private FlashSaleProducts flashSaleProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private Orders order;

    @Column(name = "qty", nullable = false)
    private Integer quantity;

    // Constructors, getters, and setters
    // ...
}
