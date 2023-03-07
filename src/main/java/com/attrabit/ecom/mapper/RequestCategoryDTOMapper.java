package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RequestCategoryDTOMapper implements Function<RequestCategoryDTO, Categories> {
    @Override
    public Categories apply(RequestCategoryDTO dto) {
        Categories categories = new Categories();
        categories.setSlug(dto.slug().trim().toUpperCase());
        categories.setPosition(dto.position());
        categories.setIsSearchable(dto.isSearchable());
        categories.setIsActive(dto.isActive());
        categories.setCreatedAt(DateUtils.getDate());

        return categories;
    }
}
