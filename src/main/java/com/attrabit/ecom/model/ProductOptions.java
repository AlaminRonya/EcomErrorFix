package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_options")
@Data
public class ProductOptions {


    @SequenceGenerator(
            name = "product_options_sequence",
            sequenceName = "product_options_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_options_sequence"
    )
    @Column(name = "id")
    private Long id;

    // TODO: 2/28/2023 relationship product entity

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "options_id", referencedColumnName = "id")
    private Options options;

}
