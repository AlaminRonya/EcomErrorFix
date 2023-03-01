package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_products")
@Data
public class OrderProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;

    @Column(name = "unit_price", precision = 18, scale = 4, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "qty", nullable = false)
    private Integer quantity;

    @Column(name = "line_total", precision = 18, scale = 4, nullable = false)
    private BigDecimal lineTotal;

    // getters and setters
}
