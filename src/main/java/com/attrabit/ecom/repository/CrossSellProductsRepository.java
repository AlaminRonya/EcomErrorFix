package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.CrossSellProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrossSellProductsRepository extends JpaRepository<CrossSellProducts, Long> {
    // custom query methods if needed
}
