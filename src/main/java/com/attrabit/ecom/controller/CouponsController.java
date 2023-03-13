package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestCouponsDTO;
import com.attrabit.ecom.dto.response.ResponseCouponsDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.service.CouponsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponsController {

    private final CouponsService couponsService;

    public CouponsController(CouponsService couponsService) {
        this.couponsService = couponsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCouponsDTO> getCouponById(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseCouponsDTO coupon = couponsService.getCouponByID(id);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping
    public ResponseEntity<ResponseCouponsDTO> createCoupon(@RequestBody @Validated RequestCouponsDTO requestDTO) {
        ResponseCouponsDTO coupon = couponsService.createCoupon(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCouponsDTO> updateCouponById(@PathVariable Long id, @RequestBody @Validated RequestCouponsDTO requestDTO) throws ResourceNotFoundException {
        ResponseCouponsDTO coupon = couponsService.updateCouponByID(id, requestDTO);
        return ResponseEntity.ok(coupon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponById(@PathVariable Long id) throws ResourceNotFoundException {
        couponsService.deleteCouponByID(id);
        return ResponseEntity.noContent().build();
    }

}
