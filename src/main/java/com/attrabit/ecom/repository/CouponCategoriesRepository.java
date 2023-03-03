package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.CouponCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponCategoriesRepository extends JpaRepository<CouponCategories, Long> {
    // add any custom methods here
}
