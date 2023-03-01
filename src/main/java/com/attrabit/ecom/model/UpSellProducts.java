package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "up_sell_products")
@Data
public class UpSellProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "up_sell_product_id", nullable = false)
    private Products upSellProduct;

}
