package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "settings")
@Data
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_translatable")
    private Boolean isTranslatable;

    @Column(name = "setting_key")
    private String key;

    @Column(name = "plain_value")
    private String plainValue;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
