package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "reminders")
@Data
public class Reminder {
    @SequenceGenerator(
            name = "reminders_sequence",
            sequenceName = "reminders_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reminders_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "completed")
    private Boolean completed;

    @Column(name = "completed_at")
    private Date completedAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;

    // getters and setters
}
