package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "attributes")
@Data
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attribute_set_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_attributes_attribute_sets"))
    private AttributeSets attributeSet;

    @Column(name = "is_filterable", nullable = false)
    private Boolean isFilterable;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "slug")
    private String slug;

    // getters and setters
}
