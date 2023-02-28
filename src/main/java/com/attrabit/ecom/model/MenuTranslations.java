package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menus_translations")
@Data
public class MenuTranslations {
    @SequenceGenerator(
            name = "menu_translations_sequence",
            sequenceName = "menu_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String locale;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "menus_id", referencedColumnName = "id")
    private Menus menus;
}
