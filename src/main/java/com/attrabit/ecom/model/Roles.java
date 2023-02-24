package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Roles {
    @SequenceGenerator(
            name = "roles_sequence",
            sequenceName = "roles_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "roles_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "permissions", columnDefinition = "text")
    private String permissions;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<RoleTranslations> translations;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles;
}
