package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "categories")
@Data
public class Categories {
    @SequenceGenerator(
            name = "categories_sequence",
            sequenceName = "categories_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categories_sequence"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_categories_parent_id"))
    private Categories parent;

    @Column(name = "slug")
    private String slug;

    @Column(name = "position")
    private Integer position;


    @Column(name = "is_searchable")
    private Boolean isSearchable;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    @OneToMany(orphanRemoval = true, mappedBy = "categories")
    private List<MenuItems> menuItems;

    @OneToMany(orphanRemoval = true, mappedBy = "categories")
    private List<CategoryTranslations> categoryTranslations;


}
