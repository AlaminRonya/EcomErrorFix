package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.dto.respose.ResponseCategoryDTO;
import com.attrabit.ecom.exception.ApiException;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.mapper.RequestCategoryDTOMapper;
import com.attrabit.ecom.mapper.ResponseCategoryDTOMapper;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService, CategorySearchService{
    private final CategoriesRepository categoriesRepository;
    private final RequestCategoryDTOMapper requestCategoryDTOMapper;
    private final ResponseCategoryDTOMapper responseCategoryDTOMapper;

    @Override
    public void addCategory(RequestCategoryDTO dto) throws ApiMessage{
        try {
            if (searchSlug((dto.subSlug() != null) ? dto.subSlug() : dto.slug()) != null){
                throw new ApiMessage("Already Category existed!");
            }
            if ((dto.subSlug() == null || dto.subSlug().equals("")) && searchSlug(dto.slug()) != null){
                throw new ApiMessage("Already Category existed!");
            }
            final Categories categories = requestCategoryDTOMapper.apply(dto);
            final Categories slug = searchSlug(dto.slug());
            if (!Objects.equals(dto.subSlug(), "") && dto.subSlug() != null && slug != null){
                categories.setSlug(dto.subSlug().trim().toUpperCase());
                categories.setParent(slug);
            }
            categoriesRepository.save(categories);

        }catch (Exception e){
            throw new ApiMessage("Category is not inserted!");
        }
    }

    @Override
    public List<ResponseCategoryDTO> getAllCategory() {
        return categoriesRepository.findAll().stream().map(responseCategoryDTOMapper).toList();
    }

    @Override
    public void deleteCategory(String slug) throws ApiMessage {
        final Categories categories = searchSlug(slug);
        if (categories != null){
            categoriesRepository.deleteById(categories.getId());
        }else {
            throw new ApiMessage("No search by slug name");
        }
    }

    @Override
    public void updateCategory(String slug, String slug2) throws ApiMessage {
        final Categories categories = searchSlug(slug);
        if (categories != null){
            categories.setSlug(slug2.trim().toUpperCase());
            categoriesRepository.save(categories);
        }else {
            throw new ApiMessage("No search by slug name");
        }
    }

    private Categories searchSlug(String slug){
        return categoriesRepository.findBySlug(slug.trim().toUpperCase()).orElse(null);
    }

    @Override
    public ResponseCategoryDTO getCategoryBySlug(String slug) {

        return responseCategoryDTOMapper.apply(searchSlug(slug));
    }

    @Override
    public List<ResponseCategoryDTO> getAllSubCategory(String slug) {
        final Categories categories = searchSlug(slug);
        if (categories == null){
            return null;
        }

        final Optional<List<Categories>> byParent = categoriesRepository.findAllByParent(categories);
        if (byParent.isEmpty()){
            return null;
        }
        List<ResponseCategoryDTO> categoryDTOList = new ArrayList<>();
        for (Categories c: byParent.get()){
            categoryDTOList.add(responseCategoryDTOMapper.apply(c));
        }
        return categoryDTOList;
    }


}
