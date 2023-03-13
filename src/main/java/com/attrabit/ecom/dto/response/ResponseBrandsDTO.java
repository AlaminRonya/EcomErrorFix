package com.attrabit.ecom.dto.response;

import java.util.Date;

public record ResponseBrandsDTO(Long id, String brandName, String slug, Boolean isActive, Date createdAt, Date updatedAt) {

}
