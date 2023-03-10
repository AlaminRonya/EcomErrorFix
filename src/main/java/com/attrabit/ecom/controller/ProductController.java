package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody RequestProductDTO dto){
        productService.addProduct(dto);
        return new ResponseEntity<>("Add product", HttpStatus.CREATED);
    }

    @GetMapping("/product/all")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
}
