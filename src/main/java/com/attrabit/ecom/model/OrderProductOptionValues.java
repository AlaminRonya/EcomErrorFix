package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_product_option_values")
@Data
public class OrderProductOptionValues {
    @SequenceGenerator(
            name = "order_product_option_values_sequence",
            sequenceName = "order_product_option_values_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_product_option_values_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private Double price;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "option_values_id", referencedColumnName = "id")
    private OptionValues optionValues;

    // constructors, getters and setters
}
