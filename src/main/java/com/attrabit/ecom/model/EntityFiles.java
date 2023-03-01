package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "entity_files")
@Data
public class EntityFiles {
    @SequenceGenerator(
            name = "entity_files_sequence",
            sequenceName = "entity_files_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "entity_files_sequence"
    )
    @Column(name = "id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "file_id", referencedColumnName = "id", nullable = false)
//    private Files file;

    @ManyToOne(fetch = FetchType.LAZY) //, targetEntity = User.class)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private Attachment file;

    @Column(name = "entity_type")
    private String entityType;

//    @Column(name = "entity_id")
//    private Long entityId;

    @Column(name = "zone")
    private String zone;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Constructors, getters, and setters
    // ...
}
