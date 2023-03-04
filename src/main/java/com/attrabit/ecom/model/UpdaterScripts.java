package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "updater_scripts")
@Data
public class UpdaterScripts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "script", nullable = false)
    private String script;

    // Constructors, getters and setters, and other methods
}
