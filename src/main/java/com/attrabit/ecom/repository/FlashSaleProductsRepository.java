package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.FlashSaleProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashSaleProductsRepository extends JpaRepository<FlashSaleProducts, Long> {
}
