package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.AttributeCategories;
import com.attrabit.ecom.service.AttributeCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attributecategories")
public class AttributeCategoriesController {

    private final AttributeCategoriesService attributeCategoriesService;

    @Autowired
    public AttributeCategoriesController(AttributeCategoriesService attributeCategoriesService) {
        this.attributeCategoriesService = attributeCategoriesService;
    }

    @GetMapping
    public List<AttributeCategories> findAll() {
        return attributeCategoriesService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AttributeCategories> findById(@PathVariable Long id) {
        return attributeCategoriesService.findById(id);
    }

    @PostMapping
    public AttributeCategories save(@RequestBody AttributeCategories attributeCategories) {
        return attributeCategoriesService.save(attributeCategories);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        attributeCategoriesService.deleteById(id);
    }
}
