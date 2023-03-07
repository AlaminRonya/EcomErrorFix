package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Categories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Optional<Categories> findBySlug(String slug);
}
