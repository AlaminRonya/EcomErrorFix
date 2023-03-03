package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "option_value_translations")
@Data
public class OptionValueTranslations {
    @SequenceGenerator(
            name = "option_value_translations_sequence",
            sequenceName = "option_value_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "option_value_translations_sequence"
    )
    @Column(name = "id")
    private Long id;
    @Column(name = "price" +
            "")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "option_values_id", referencedColumnName = "id")
    private OptionValues optionValues;
}
