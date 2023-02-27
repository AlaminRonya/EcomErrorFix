package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coupons_products")
@Data
public class CouponProducts {
    @SequenceGenerator(
            name = "coupons_products_sequence",
            sequenceName = "coupons_products_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupons_products_sequence"
    )
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "coupon_id", referencedColumnName = "id", nullable = false)
//    private Coupons coupon;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
//    private Products product;

    @Column(name = "exclude", columnDefinition = "TINYINT(1)")
    private boolean exclude;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupons coupons;

    // TODO: 2/27/2023 product relationship

    // getters and setters
    // ...
}
