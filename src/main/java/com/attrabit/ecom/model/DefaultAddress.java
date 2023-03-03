package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "default_addresses")
@Data
public class DefaultAddress {
    @SequenceGenerator(
            name = "default_addresses_sequence",
            sequenceName = "default_addresses_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "default_addresses_sequence"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addresses_id", referencedColumnName = "id")
    private Addresses addresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_id", referencedColumnName = "id")
    private Users customers;



}