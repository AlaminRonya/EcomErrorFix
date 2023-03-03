package com.attrabit.ecom.service;

import com.attrabit.ecom.model.CouponCategories;
import com.attrabit.ecom.repository.CouponCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponCategoriesService {

    @Autowired
    private CouponCategoriesRepository couponCategoriesRepository;

    public List<CouponCategories> getAllCouponCategories() {
        return couponCategoriesRepository.findAll();
    }

    public Optional<CouponCategories> getCouponCategoryById(Long id) {
        return couponCategoriesRepository.findById(id);
    }

    public CouponCategories saveCouponCategory(CouponCategories couponCategory) {
        return couponCategoriesRepository.save(couponCategory);
    }

    public void deleteCouponCategoryById(Long id) {
        couponCategoriesRepository.deleteById(id);
    }

    // add any custom methods here
}
