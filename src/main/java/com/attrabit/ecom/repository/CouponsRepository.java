package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons, Long> {
}
