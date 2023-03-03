package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.FlashSales;
import com.attrabit.ecom.service.FlashSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flashsales")
public class FlashSalesController {

    @Autowired
    private FlashSalesService flashSalesService;

    @GetMapping("")
    public ResponseEntity<List<FlashSales>> getAllFlashSales() {
        List<FlashSales> flashSalesList = flashSalesService.getAllFlashSales();
        return new ResponseEntity<>(flashSalesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlashSales> getFlashSalesById(@PathVariable Long id) {
        Optional<FlashSales> flashSales = flashSalesService.getFlashSalesById(id);
        if (flashSales.isPresent()) {
            return new ResponseEntity<>(flashSales.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<FlashSales> saveFlashSales(@RequestBody FlashSales flashSales) {
        FlashSales savedFlashSales = flashSalesService.saveFlashSales(flashSales);
        return new ResponseEntity<>(savedFlashSales, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlashSalesById(@PathVariable Long id) {
        flashSalesService.deleteFlashSalesById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
