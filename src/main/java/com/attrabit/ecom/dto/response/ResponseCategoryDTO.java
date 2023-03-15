package com.attrabit.ecom.dto.response;

import com.attrabit.ecom.model.Categories;
import jakarta.persistence.*;

import java.util.Date;

public record ResponseCategoryDTO(
        Long id, Long parent,String slug,Integer position,
        Boolean isSearchable,Boolean isActive,Date createdAt,Date updatedAt
) {
}
