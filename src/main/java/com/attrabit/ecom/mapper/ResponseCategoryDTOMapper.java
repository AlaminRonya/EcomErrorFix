package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.dto.respose.ResponseAttachmentDTO;
import com.attrabit.ecom.dto.respose.ResponseCategoryDTO;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResponseCategoryDTOMapper implements Function<Categories, ResponseCategoryDTO> {

    @Override
    public ResponseCategoryDTO apply(Categories categories) {
        return (categories != null) ? new ResponseCategoryDTO(
                categories.getId(), (categories.getParent() != null) ? categories.getParent().getId() : null,
                categories.getSlug(), categories.getPosition(), categories.getIsSearchable(),
                categories.getIsActive(), categories.getCreatedAt(), categories.getUpdatedAt()
        ) :null;
    }
}
