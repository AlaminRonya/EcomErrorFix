package com.attrabit.ecom.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "products")
@Entity
public class Products {

    @SequenceGenerator(
            name = "products_sequence",
            sequenceName = "products_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_sequence"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_products_brand"))
    private Brands brand;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "tax_class_id")
    private Long taxClassId;

    @Column(name = "slug")
    private String slug;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "special_price")
    private BigDecimal specialPrice;

    @Column(name = "special_price_type")
    private String specialPriceType;

    @Column(name = "special_price_start")
    private Date specialPriceStart;

    @Column(name = "special_price_end")
    private Date specialPriceEnd;

    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    @Column(name = "sku")
    private String sku;

    @Column(name = "manage_stock")
    private Boolean manageStock;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "in_stock")
    private Boolean inStock;

    @Column(name = "viewed")
    private Long viewed;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "new_from")
    private Date newFrom;

    @Column(name = "new_to")
    private Date newTo;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "virtual_at")
    private Boolean virtualAt;

    // getters and setters
}
