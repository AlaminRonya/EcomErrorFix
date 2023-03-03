package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.FlashSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashSalesRepository extends JpaRepository<FlashSales, Long> {
}
