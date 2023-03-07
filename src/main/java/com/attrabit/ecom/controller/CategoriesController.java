package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestCategoryDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Categories;
import com.attrabit.ecom.service.CategoriesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;
    @PostMapping("/api/v1/users/addCategory")
    public ResponseEntity<?> addCategory(@Valid @RequestBody RequestCategoryDTO dto) throws ApiMessage {
        categoriesService.addCategory(dto);
        return new ResponseEntity<>("add Category", HttpStatus.OK);
    }

    @GetMapping("/api/v1/users/addCategory/all")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(categoriesService.getAllCategory(), HttpStatus.OK);
    }
    @GetMapping("/api/v1/users/addCategory/delete/{name}")
    public ResponseEntity<?> deleteCategoryBySlug(@PathVariable("name") String slug) throws ApiMessage {
        categoriesService.deleteCategory(slug);
        return new ResponseEntity<>("Deleted category", HttpStatus.OK);
    }
//    @GetMapping("")
//    public List<Categories> getAllCategories() {
//        return categoriesService.getAllCategories();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Categories> getCategoryById(@PathVariable Long id) {
//        return categoriesService.getCategoryById(id)
//                .map(category -> ResponseEntity.ok().body(category))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("")
//    public Categories saveCategory(@RequestBody Categories category) {
//        return categoriesService.saveCategory(category);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteCategoryById(@PathVariable Long id) {
//        categoriesService.deleteCategoryById(id);
//        return HttpStatus.OK;
//    }
}
