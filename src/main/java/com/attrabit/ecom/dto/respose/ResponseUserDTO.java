package com.attrabit.ecom.dto.respose;


import java.util.Date;

public record ResponseUserDTO(
        Long id, String firstName, String lastName, String email,
        String phone, String password, String permissions,
        Date lastLogin, Date createdAt, Date updatedAt
) {
}
