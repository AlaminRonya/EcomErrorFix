package com.attrabit.ecom.dto.request;

import jakarta.persistence.Column;

public record RequestAddressDTO(
        String firstName,String lastName,String address1, String address2,
        String city,String state,String zip,String country
) {
}
