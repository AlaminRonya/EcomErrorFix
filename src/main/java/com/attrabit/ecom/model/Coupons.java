package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
@Data
@ToString
public class Coupons {

    @SequenceGenerator(
            name = "coupons_sequence",
            sequenceName = "coupons_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupons_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(precision = 18, scale = 4)
    private BigDecimal value;

    @Column(name = "is_percent")
    private Boolean isPercent;

    @Column(name = "free_shipping")
    private Boolean freeShipping;

    @Column(name = "minimum_spend", precision = 18, scale = 4)
    private BigDecimal minimumSpend;

    @Column(name = "maximum_spend",precision = 18, scale = 4)
    private BigDecimal maximumSpend;

    @Column(name = "usage_limit_per_coupon")
    private Integer usageLimitPerCoupon;

    @Column(name = "usage_limit_per_customer")
    private Integer usageLimitPerCustomer;

    @Column(name = "used")
    private Integer used;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "coupons")
    private List<CouponTranslations> couponTranslations;

    @OneToMany(orphanRemoval = true, mappedBy = "coupons")
    private List<CouponProducts> coupons;
    // Getters and setters

    @OneToMany(orphanRemoval = true, mappedBy = "coupons")
    private List<CouponCategories> couponCategories;
}