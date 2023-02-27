package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coupons_translations")
public class CouponTranslations {
    @SequenceGenerator(
            name = "coupons_translations_sequence",
            sequenceName = "coupons_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupons_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String locale;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "coupon_id", referencedColumnName = "id")
    private Coupons coupons;
}
