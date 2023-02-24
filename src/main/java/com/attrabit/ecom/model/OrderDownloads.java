package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_downloads")
@Data
public class OrderDownloads {

    @SequenceGenerator(
            name = "order_downloads_sequence",
            sequenceName = "order_downloads_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_downloads_sequence"
    )
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Orders order;
//
//    @ManyToOne
//    @JoinColumn(name = "file_id", referencedColumnName = "id")
//    private Files file;


}
