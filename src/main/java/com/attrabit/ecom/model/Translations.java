package com.attrabit.ecom.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "translations")
public class Translations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "translation_key", length = 191, nullable = false)
    private String translationKey;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Constructors, getters, and setters

}


