package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("")
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable Long id) {
        return categoriesService.getCategoryById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Categories saveCategory(@RequestBody Categories category) {
        return categoriesService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCategoryById(@PathVariable Long id) {
        categoriesService.deleteCategoryById(id);
        return HttpStatus.OK;
    }
}
