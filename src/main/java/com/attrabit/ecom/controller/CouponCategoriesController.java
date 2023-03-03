package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.CouponCategories;
import com.attrabit.ecom.service.CouponCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/couponCategories")
public class CouponCategoriesController {

    @Autowired
    private CouponCategoriesService couponCategoriesService;

    @GetMapping
    public List<CouponCategories> getAllCouponCategories() {
        return couponCategoriesService.getAllCouponCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponCategories> getCouponCategoryById(@PathVariable Long id) {
        Optional<CouponCategories> couponCategory = couponCategoriesService.getCouponCategoryById(id);
        return couponCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<CouponCategories> saveCouponCategory(@RequestBody CouponCategories couponCategory) {
        CouponCategories savedCouponCategory = couponCategoriesService.saveCouponCategory(couponCategory);
        return ResponseEntity.ok(savedCouponCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CouponCategories> updateCouponCategory(@PathVariable Long id, @RequestBody CouponCategories couponCategory) {
        Optional<CouponCategories> existingCouponCategory = couponCategoriesService.getCouponCategoryById(id);
        if (existingCouponCategory.isPresent()) {
            couponCategory.setId(id);
            CouponCategories updatedCouponCategory = couponCategoriesService.saveCouponCategory(couponCategory);
            return ResponseEntity.ok(updatedCouponCategory);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponCategoryById(@PathVariable Long id) {
        Optional<CouponCategories> couponCategory = couponCategoriesService.getCouponCategoryById(id);
        if (couponCategory.isPresent()) {
            couponCategoriesService.deleteCouponCategoryById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // add any custom methods here
}
