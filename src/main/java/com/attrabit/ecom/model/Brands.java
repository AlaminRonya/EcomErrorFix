package com.attrabit.ecom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "brands")
@Data

public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @Column(name = "slug", nullable = false)
    private String slug;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

//    public Brands(String brandName, String slug, @NotBlank String s, Boolean isActive, Object o, Object o1) {
//        this.brandName = brandName;
//        this.slug = slug;
//        this.isActive = isActive;
//    }

}
