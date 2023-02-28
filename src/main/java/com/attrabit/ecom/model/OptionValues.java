package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "option_values")
@Data
public class OptionValues {

    @SequenceGenerator(
            name = "option_values_sequence",
            sequenceName = "option_values_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "option_values_sequence"
    )
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "option_id", nullable = false, updatable = false)
//    private Options option;

    @Column(name = "price")
    private Double price;

    @Column(name = "price_type", nullable = false)
    private String priceType;

    @Column(name = "position", nullable = false)
    private Integer position;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "options_id", referencedColumnName = "id")
    private Options options;

    @OneToMany(orphanRemoval = true, mappedBy = "optionValues")
    private List<OptionValueTranslations> optionValueTranslations;

    // constructors, getters and setters
}

