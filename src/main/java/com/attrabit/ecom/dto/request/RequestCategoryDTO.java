package com.attrabit.ecom.dto.request;

import com.attrabit.ecom.annotation.NullValid;

public record RequestCategoryDTO(
        @NullValid
        String slug,
        String subSlug,Integer position,Boolean isSearchable,
        Boolean isActive
) {

}
