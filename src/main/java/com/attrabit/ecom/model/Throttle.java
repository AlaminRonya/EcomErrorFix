package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "throttle")
@Data
public class Throttle {

    @SequenceGenerator(
            name = "throttle_sequence",
            sequenceName = "throttle_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "throttle_sequence"
    )
    @Column(name = "id")
    private Long id;


    @Column(name = "type")
    private String type;

    @Column(name = "ip")
    private String ip;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users users;


}
