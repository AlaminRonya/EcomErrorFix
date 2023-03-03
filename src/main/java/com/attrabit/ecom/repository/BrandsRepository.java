package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, Long> {
}
