package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByProductName(String name);
}
