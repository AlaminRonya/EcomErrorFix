package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        return categoriesRepository.findById(id);
    }

    public Categories saveCategory(Categories category) {
        return categoriesRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        categoriesRepository.deleteById(id);
    }
}
