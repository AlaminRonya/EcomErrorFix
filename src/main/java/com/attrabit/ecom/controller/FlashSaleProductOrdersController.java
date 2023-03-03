package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.FlashSaleProductOrders;
import com.attrabit.ecom.service.FlashSaleProductOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flash-sale-product-orders")
public class FlashSaleProductOrdersController {

    @Autowired
    private FlashSaleProductOrdersService flashSaleProductOrdersService;

    @PostMapping
    public ResponseEntity<FlashSaleProductOrders> createFlashSaleProductOrder(@RequestBody FlashSaleProductOrders flashSaleProductOrder) {
        FlashSaleProductOrders createdFlashSaleProductOrder = flashSaleProductOrdersService.saveFlashSaleProductOrder(flashSaleProductOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlashSaleProductOrder);
    }

    // other controller methods
    // ...
}
