package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.model.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByProductName(String name);
    Optional<List<Products>> findAllByBrand(Brands brands);
    Optional<List<Products>> findAllBySlug(String slug);
}
