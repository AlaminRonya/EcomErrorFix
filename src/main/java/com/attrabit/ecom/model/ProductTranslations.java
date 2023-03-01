package com.attrabit.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_translations")
public class ProductTranslations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(nullable = false, length = 191)
    private String locale;

    @Column(nullable = false, length = 191)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Lob
    @Column(name = "short_description")
    private String shortDescription;

    // getters and setters
}
