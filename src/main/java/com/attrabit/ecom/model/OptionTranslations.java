package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "option_translations")
@Data
public class OptionTranslations {
    @SequenceGenerator(
            name = "option_translations_sequence",
            sequenceName = "option_translations_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "option_translations_sequence"
    )
    @Column(name = "id")
    private Long id;

    private String locale;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "options_id", referencedColumnName = "id")
    private Options options;

}
