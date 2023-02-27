package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menu_items")
@Data
public class MenuItems {
    @SequenceGenerator(
            name = "menu_items_sequence",
            sequenceName = "menu_items_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_items_sequence"
    )
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_menu_item_parent_id"))
    private MenuItems parent;
    private String type;
    private String url;
    private String icon;
    private String  target;
    private Integer position;
    @Column(name = "is_root")
    private Boolean isRoot;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "menuItems")
    private List<MenuItemTranslations> menuItemTranslations;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories categories;
}
