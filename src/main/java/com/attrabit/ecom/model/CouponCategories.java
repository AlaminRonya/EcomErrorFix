package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coupon_categories")
@Data
public class CouponCategories {

    @SequenceGenerator(
            name = "coupon_categories_sequence",
            sequenceName = "coupon_categories_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_categories_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "exclude")
    private boolean exclude;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "coupons_id", referencedColumnName = "id")
    private Coupons coupons;



    // getters and setters


}
