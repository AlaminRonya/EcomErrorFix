package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Brands;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface BrandsRepository extends JpaRepository<Brands, Long> {
    Optional<Brands> findByBrandName(String brandName);
}

