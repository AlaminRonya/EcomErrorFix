package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.AttributeCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeCategoriesRepository extends JpaRepository<AttributeCategories, Long> {
    // add custom methods here if needed
}
