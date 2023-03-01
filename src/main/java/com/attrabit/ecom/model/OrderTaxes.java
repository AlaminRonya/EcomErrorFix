package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_taxes")
@Data
public class OrderTaxes {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_rate_id", nullable = false)
    private TaxRates taxRate;

    @Column(name = "amount", precision = 15, scale = 4, nullable = false)
    private BigDecimal amount;

    // constructors, getters and setters
}
