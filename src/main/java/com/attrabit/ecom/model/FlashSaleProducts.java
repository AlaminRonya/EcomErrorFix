package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "flash_sale_products")
@Data
public class FlashSaleProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flash_sale_id", referencedColumnName = "id", nullable = false)
    private FlashSales flashSale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Products product;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "qty", nullable = false)
    private Integer quantity;

    @Column(name = "position")
    private Integer position;

    // Constructors, getters, and setters
    // ...
}
