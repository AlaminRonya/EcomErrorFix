package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.dto.respose.ResponseCategoryDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategoriesService {
    void addCategory(RequestCategoryDTO dto) throws ApiMessage;
    List<ResponseCategoryDTO> getAllCategory();
    void deleteCategory(String slug) throws ApiMessage;
    void updateCategory(String slug, String slug2) throws ApiMessage;
}
