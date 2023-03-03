package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.CouponProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponProductsRepository extends JpaRepository<CouponProducts, Long> {
}
