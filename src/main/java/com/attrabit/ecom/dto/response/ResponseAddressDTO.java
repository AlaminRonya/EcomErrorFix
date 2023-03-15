package com.attrabit.ecom.dto.response;

import com.attrabit.ecom.model.Users;

import java.util.Date;

public record ResponseAddressDTO(
        Long id,String firstName,String lastName,String address1,
        String address2,String city,String state,String zip,
        String country,Date createdAt, Date updatedAt
) {
}
