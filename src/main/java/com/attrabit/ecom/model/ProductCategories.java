package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_categories")
@Data
public class ProductCategories {

    @SequenceGenerator(
            name = "product_categories_sequence",
            sequenceName = "product_categories_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_categories_sequence"
    )
    @Column(name = "id")
    private Long id;

//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    private Products product;
//
//    @ManyToOne (cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Categories category;
    // TODO: 2/27/2023 relationship productCategory to product

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;


}
