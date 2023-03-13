package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.respose.ResponseCategoryDTO;

import java.util.List;

public interface CategorySearchService {
    ResponseCategoryDTO getCategoryBySlug(String slug);
    List<ResponseCategoryDTO> getAllSubCategory(String slug);
}
