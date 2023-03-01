package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_tags")
@Data
public class ProductTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_product_tags_products"))
    private Products product;

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "FK_product_tags_tags"))
    private Tags tag;

}
