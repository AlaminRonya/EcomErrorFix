package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestBrandsDTO;
import com.attrabit.ecom.dto.response.ResponseBrandsDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.service.BrandsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandsController {

    private final BrandsService brandsService;

    @Autowired
    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBrandsDTO> getBrandById(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseBrandsDTO brand = brandsService.getBrandById(id);
        return ResponseEntity.ok(brand);
    }

    @GetMapping
    public ResponseEntity<List<ResponseBrandsDTO>> getAllBrands() {
        List<ResponseBrandsDTO> brands = brandsService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    @PostMapping
    public ResponseEntity<ResponseBrandsDTO> createBrand(@Valid @RequestBody RequestBrandsDTO requestBrandsDTO) {
        System.out.println(requestBrandsDTO);
        ResponseBrandsDTO brand = brandsService.createBrand(requestBrandsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBrandsDTO> updateBrand(@PathVariable Long id, @Valid @RequestBody RequestBrandsDTO requestBrandsDTO) throws ResourceNotFoundException {
        ResponseBrandsDTO brand = brandsService.updateBrand(id, requestBrandsDTO);
        return ResponseEntity.ok(brand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) throws ResourceNotFoundException {
        brandsService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{brandName}")
    public ResponseEntity<List<ResponseBrandsDTO>> searchBrandByName(@PathVariable("brandName") String brandName) {
//        System.out.println(brandName);
//        return null;
        List<ResponseBrandsDTO> brands = brandsService.searchBrandByName(brandName);
        return ResponseEntity.ok(brands);
    }
}
