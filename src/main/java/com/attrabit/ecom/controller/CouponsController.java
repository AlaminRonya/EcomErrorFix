package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Coupons;
import com.attrabit.ecom.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    private final CouponsService couponsService;

    @Autowired
    public CouponsController(CouponsService couponsService) {
        this.couponsService = couponsService;
    }

    @PostMapping
    public ResponseEntity<Coupons> createCoupon(@RequestBody Coupons coupon) {
        Coupons savedCoupon = couponsService.save(coupon);
        return new ResponseEntity<>(savedCoupon, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupons> getCouponById(@PathVariable Long id) {
        Optional<Coupons> coupon = couponsService.findById(id);
        if (coupon.isPresent()) {
            return new ResponseEntity<>(coupon.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Coupons> getAllCoupons() {
        return couponsService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponById(@PathVariable Long id) {
        Optional<Coupons> coupon = couponsService.findById(id);
        if (coupon.isPresent()) {
            couponsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
