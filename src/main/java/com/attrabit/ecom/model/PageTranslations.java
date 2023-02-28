package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "page_translations")
@Data
public class PageTranslations {

    @SequenceGenerator(
            name = "page_translations_sequence",
            sequenceName = "page_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "page_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "locale")
    private String locale;
    @Column(name = "name")
    private String name;
    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "pages_id", referencedColumnName = "id")
    private Pages pages;


    // getters and setters
    // ...

}
