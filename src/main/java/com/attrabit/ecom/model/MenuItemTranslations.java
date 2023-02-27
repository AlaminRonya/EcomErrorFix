package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "menu_item_translations")
@Data
public class MenuItemTranslations {
    @SequenceGenerator(
            name = "menu_item_translations_sequence",
            sequenceName = "menu_item_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_item_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String locale;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "menu_item_id", referencedColumnName = "id")
    private MenuItems menuItems;
}
