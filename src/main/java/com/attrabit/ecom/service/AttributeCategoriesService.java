package com.attrabit.ecom.service;

import com.attrabit.ecom.model.AttributeCategories;
import com.attrabit.ecom.repository.AttributeCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeCategoriesService {

    private final AttributeCategoriesRepository attributeCategoriesRepository;

    @Autowired
    public AttributeCategoriesService(AttributeCategoriesRepository attributeCategoriesRepository) {
        this.attributeCategoriesRepository = attributeCategoriesRepository;
    }

    public List<AttributeCategories> findAll() {
        return attributeCategoriesRepository.findAll();
    }

    public Optional<AttributeCategories> findById(Long id) {
        return attributeCategoriesRepository.findById(id);
    }

    public AttributeCategories save(AttributeCategories attributeCategories) {
        return attributeCategoriesRepository.save(attributeCategories);
    }

    public void deleteById(Long id) {
        attributeCategoriesRepository.deleteById(id);
    }
}
