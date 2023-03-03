package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.CrossSellProducts;
import com.attrabit.ecom.service.CrossSellProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cross-sell-products")
public class CrossSellProductsController {

    private final CrossSellProductsService crossSellProductsService;

    @Autowired
    public CrossSellProductsController(CrossSellProductsService crossSellProductsService) {
        this.crossSellProductsService = crossSellProductsService;
    }

    @GetMapping("/")
    public List<CrossSellProducts> getAllCrossSellProducts() {
        return crossSellProductsService.getAllCrossSellProducts();
    }

    @GetMapping("/{id}")
    public CrossSellProducts getCrossSellProductById(@PathVariable Long id) {
        return crossSellProductsService.getCrossSellProductById(id);
    }

    @PostMapping("/")
    public CrossSellProducts createCrossSellProduct(@RequestBody CrossSellProducts crossSellProduct) {
        return crossSellProductsService.saveCrossSellProduct(crossSellProduct);
    }

    @PutMapping("/{id}")
    public CrossSellProducts updateCrossSellProduct(@PathVariable Long id, @RequestBody CrossSellProducts crossSellProduct) {
        CrossSellProducts existingCrossSellProduct = crossSellProductsService.getCrossSellProductById(id);
        existingCrossSellProduct.setProduct(crossSellProduct.getProduct());
        existingCrossSellProduct.setCrossSellProduct(crossSellProduct.getCrossSellProduct());
        return crossSellProductsService.saveCrossSellProduct(existingCrossSellProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteCrossSellProduct(@PathVariable Long id) {
        CrossSellProducts crossSellProduct = crossSellProductsService.getCrossSellProductById(id);
        crossSellProductsService.deleteCrossSellProduct(crossSellProduct);
    }
}
