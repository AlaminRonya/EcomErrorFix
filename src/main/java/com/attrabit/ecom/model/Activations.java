package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "activations")
@Data
public class Activations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Column(name = "code", nullable = false, length = 191)
    private String code;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "completed_at", nullable = true)
    private Date completedAt;

    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;

    // getters and setters
}
