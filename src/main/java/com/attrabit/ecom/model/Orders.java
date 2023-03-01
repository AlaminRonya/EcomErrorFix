package com.attrabit.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
//@RequiredArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_first_name", nullable = false)
    private String customerFirstName;

    @Column(name = "customer_last_name", nullable = false)
    private String customerLastName;

    @Column(name = "billing_first_name", nullable = false)
    private String billingFirstName;

    @Column(name = "billing_last_name", nullable = false)
    private String billingLastName;

    @Column(name = "billing_address_1", nullable = false)
    private String billingAddress1;

    @Column(name = "billing_address_2")
    private String billingAddress2;

    @Column(name = "billing_city", nullable = false)
    private String billingCity;

    @Column(name = "billing_state", nullable = false)
    private String billingState;

    @Column(name = "billing_zip", nullable = false)
    private String billingZip;

    @Column(name = "billing_country", nullable = false)
    private String billingCountry;

    @Column(name = "shipping_first_name", nullable = false)
    private String shippingFirstName;

    @Column(name = "shipping_last_name", nullable = false)
    private String shippingLastName;

    @Column(name = "shipping_address_1", nullable = false)
    private String shippingAddress1;

    @Column(name = "shipping_address_2")
    private String shippingAddress2;

    @Column(name = "shipping_city", nullable = false)
    private String shippingCity;

    @Column(name = "shipping_state", nullable = false)
    private String shippingState;

    // constructors, getters, and setters

}
