package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_product_options")
@Data
public class OrderProductOptions {
    @SequenceGenerator(
            name = "order_product_options_sequence",
            sequenceName = "order_product_options_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_product_options_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "options_id", referencedColumnName = "id")
    private Options options;

}
