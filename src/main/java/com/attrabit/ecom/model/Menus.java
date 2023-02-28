package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menus")
@Data
public class Menus {
    @SequenceGenerator(
            name = "menus_sequence",
            sequenceName = "menus_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menus_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "menus")
    private List<MenuTranslations> menuTranslations;

    // Constructors, getters, and setters
}
