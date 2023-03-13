package com.attrabit.ecom.dto.request;

import com.attrabit.ecom.annotation.NullValid;
import jakarta.validation.constraints.NotBlank;

public record RequestBrandsDTO(
        @NullValid
        String brandName,
        @NullValid
        String slug,

        boolean isActive) {
}

