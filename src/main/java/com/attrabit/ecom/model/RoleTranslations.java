package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "role_translations")
@Data
public class RoleTranslations {
    @SequenceGenerator(
            name = "role_translations_sequence",
            sequenceName = "role_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_translations_sequence"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Roles role;

    @Column(name = "locale")
    private String locale;

    @Column(name = "name")
    private String name;

}
