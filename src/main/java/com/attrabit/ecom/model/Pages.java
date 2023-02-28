package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pages")
@Data
public class Pages {

    @SequenceGenerator(
            name = "pages_sequence",
            sequenceName = "pages_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pages_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "slug")
    private String slug;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "pages")
    private List<PageTranslations> pageTranslations;

    // getters and setters
    // ...

}
