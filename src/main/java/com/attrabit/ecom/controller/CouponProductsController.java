package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.CouponProducts;
import com.attrabit.ecom.service.CouponProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon-products")
public class CouponProductsController {

    private final CouponProductsService couponProductsService;

    @Autowired
    public CouponProductsController(CouponProductsService couponProductsService) {
        this.couponProductsService = couponProductsService;
    }

    @PostMapping
    public ResponseEntity<CouponProducts> createCouponProduct(@RequestBody CouponProducts couponProduct) {
        CouponProducts savedCouponProduct = couponProductsService.save(couponProduct);
        return new ResponseEntity<>(savedCouponProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponProducts> getCouponProductById(@PathVariable Long id) {
        CouponProducts couponProduct = couponProductsService.getById(id);
        if (couponProduct != null) {
            return new ResponseEntity<>(couponProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponProductById(@PathVariable Long id) {
        CouponProducts couponProduct = couponProductsService.getById(id);
        if (couponProduct != null) {
            couponProductsService.delete(couponProduct);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
