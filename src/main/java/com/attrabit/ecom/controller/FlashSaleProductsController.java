package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.FlashSaleProducts;
import com.attrabit.ecom.service.FlashSaleProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flash-sale-products")
public class FlashSaleProductsController {

    @Autowired
    private FlashSaleProductsService flashSaleProductsService;

    @GetMapping
    public List<FlashSaleProducts> getAllFlashSaleProducts() {
        return flashSaleProductsService.getAllFlashSaleProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashSaleProducts> getFlashSaleProductById(@PathVariable Long id) {
        Optional<FlashSaleProducts> flashSaleProduct = flashSaleProductsService.getFlashSaleProductById(id);
        return flashSaleProduct.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public FlashSaleProducts createFlashSaleProduct(@RequestBody FlashSaleProducts flashSaleProduct) {
        return flashSaleProductsService.saveFlashSaleProduct(flashSaleProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlashSaleProducts> updateFlashSaleProduct(@PathVariable Long id, @RequestBody FlashSaleProducts flashSaleProduct) {
        Optional<FlashSaleProducts> flashSaleProductOptional = flashSaleProductsService.getFlashSaleProductById(id);
        if (flashSaleProductOptional.isPresent()) {
            flashSaleProduct.setId(id);
            flashSaleProductsService.saveFlashSaleProduct(flashSaleProduct);
            return new ResponseEntity<>(flashSaleProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFlashSaleProductById(@PathVariable Long id) {
        try {
            flashSaleProductsService.deleteFlashSaleProductById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
