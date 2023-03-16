package com.attrabit.ecom.dto.response;


import java.util.Date;

public record ResponseTaxClassesDTO(
        Long id,String basedOn,Date deletedAt,Date createdAt,Date updatedAt
) {
}
