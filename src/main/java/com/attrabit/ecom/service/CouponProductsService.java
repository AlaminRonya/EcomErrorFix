package com.attrabit.ecom.service;

import com.attrabit.ecom.model.CouponProducts;
import com.attrabit.ecom.repository.CouponProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponProductsService {

    private final CouponProductsRepository couponProductsRepository;

    @Autowired
    public CouponProductsService(CouponProductsRepository couponProductsRepository) {
        this.couponProductsRepository = couponProductsRepository;
    }

    public CouponProducts save(CouponProducts couponProducts) {
        return couponProductsRepository.save(couponProducts);
    }

    public CouponProducts getById(Long id) {
        return couponProductsRepository.findById(id).orElse(null);
    }

    public void delete(CouponProducts couponProducts) {
        couponProductsRepository.delete(couponProducts);
    }
}
