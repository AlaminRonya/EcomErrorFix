package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category_translations")
@Data
public class CategoryTranslations {
    @SequenceGenerator(
            name = "category_translations_sequence",
            sequenceName = "category_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String locale;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;
}
