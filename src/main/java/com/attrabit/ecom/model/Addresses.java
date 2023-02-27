package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "addresses")
@Data
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Users customer;

    @Column(name = "first_name", nullable = false, length = 191)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 191)
    private String lastName;

    @Column(name = "address_1", nullable = false, length = 191)
    private String address1;

    @Column(name = "address_2", length = 191)
    private String address2;

    @Column(name = "city", nullable = false, length = 191)
    private String city;

    @Column(name = "state", nullable = false, length = 191)
    private String state;

    @Column(name = "zip", nullable = false, length = 191)
    private String zip;

    @Column(name = "country", nullable = false, length = 191)
    private String country;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    // Getters and Setters for all fields
}
