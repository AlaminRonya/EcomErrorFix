package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.dto.response.ResponseCategoryDTO;
import com.attrabit.ecom.exception.ApiMessage;


import java.util.List;
import java.util.Optional;


public interface CategoriesService {
    void addCategory(RequestCategoryDTO dto) throws ApiMessage;
    List<ResponseCategoryDTO> getAllCategory();
    void deleteCategory(String slug) throws ApiMessage;
    void updateCategory(String slug, String slug2) throws ApiMessage;
}
