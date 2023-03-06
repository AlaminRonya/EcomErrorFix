package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long> {
    Optional<Brands> findByBrandName(String brandName);
}
