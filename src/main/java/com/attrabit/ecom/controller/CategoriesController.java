package com.attrabit.ecom.controller;

import com.attrabit.ecom.annotation.NullValid;
import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.service.CategoriesService;
import com.attrabit.ecom.service.CategorySearchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;
    private final CategorySearchService categorySearchService;
    @PostMapping("/api/v1/users/addCategory")
    public ResponseEntity<?> addCategory(@Valid @RequestBody RequestCategoryDTO dto) throws ApiMessage {
        categoriesService.addCategory(dto);
        return new ResponseEntity<>("add Category", HttpStatus.OK);
    }

    @GetMapping("/api/v1/users/addCategory/all")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(categoriesService.getAllCategory(), HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/users/category/{slug}")
    public ResponseEntity<?> deleteCategory(@PathVariable("slug") String slug) throws ApiMessage {
        if (slug == null || slug.isEmpty()){
            return new ResponseEntity<>("Slug is empty or null", HttpStatus.OK);
        }
        categoriesService.deleteCategory(slug);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/api/v1/users/category/{slug1}/{slug2}")
    public ResponseEntity<?> updateCategory(@PathVariable("slug1") String slug1, @PathVariable("slug2") String slug2) throws ApiMessage {
        if (slug1 == null || slug1.isEmpty() || slug2 == null || slug2.isEmpty()){
            return new ResponseEntity<>("Slug is empty or null", HttpStatus.OK);
        }
        categoriesService.updateCategory(slug1, slug2);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
    @GetMapping("/api/v1/users/category/all/{slug}")
    public ResponseEntity<?> getAllSub(@PathVariable("slug") String slug){
        if (slug == null || slug.isEmpty()){
            return new ResponseEntity<>("Slug is empty or null", HttpStatus.OK);
        }

        return new ResponseEntity<>(categorySearchService.getAllSubCategory(slug), HttpStatus.OK);
    }

}
