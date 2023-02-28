package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "options")
@Data
public class Options {
    @SequenceGenerator(
            name = "options_sequence",
            sequenceName = "options_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "options_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "is_required")
    private Boolean isRequired;

    @Column(name = "is_global")
    private Boolean isGlobal;

    @Column(name = "position")
    private Long position;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(orphanRemoval = true, mappedBy = "options")
    private List<OptionTranslations> optionTranslations;

    @OneToMany(orphanRemoval = true, mappedBy = "options")
    private List<OrderProductOptions> orderProductOptions;

    // constructors, getters and setters
}
