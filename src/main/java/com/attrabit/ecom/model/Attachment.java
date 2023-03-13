//<--Files-->
package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "attachment")
@Data
public class Attachment {
    @SequenceGenerator(
            name = "attachment_sequence",
            sequenceName = "attachment_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attachment_sequence"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    private String filename;

    private String disk;

    private String path;

    private String extension;

    private String mime;

    private String size;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;


    @OneToMany(orphanRemoval = true, mappedBy = "file")
    private List<EntityFiles> entityFiles;


}
