package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tax_rates")
@Data
public class TaxRates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_class_id")
    private TaxClasses taxClass;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "rate", precision = 8, scale = 4, nullable = false)
    private BigDecimal rate;

    @Column(name = "position", nullable = false)
    private Long position;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    // Constructor, getters and setters
}
