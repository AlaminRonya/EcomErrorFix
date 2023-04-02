package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.response.Response;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.service.BrandSearchService;
import com.attrabit.ecom.service.BrandsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/api/v1/users/brands")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class BrandsController {

    private final BrandsServiceImpl brandsService;
    private final BrandSearchService brandSearchService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllBrands() {
        List<Brands> brandsList = brandsService.findAll();
//        return new ResponseEntity<>(brandsList, HttpStatus.OK);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("brands",brandsList))
                        .message("Success")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brands> getBrandById(@PathVariable Long id) {

        Optional<Brands> brandOptional = brandsService.findById(id);
        if (brandOptional.isPresent()) {
            Brands brand = brandOptional.get();
            return new ResponseEntity<>(brand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addBrand(@RequestBody Brands brand) throws ApiMessage {
        Brands savedBrand = brandsService.save(brand);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("brand","Inserted"))
                        .message("Success")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
//        return new ResponseEntity<>("Inserted", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brands> updateBrand(@PathVariable Long id, @RequestBody Brands brand) throws ApiMessage {
        Optional<Brands> brandOptional = brandsService.findById(id);
        if (brandOptional.isPresent()) {
            Brands existingBrand = brandOptional.get();
            existingBrand.setSlug(brand.getSlug());
            existingBrand.setIsActive(brand.getIsActive());
            existingBrand.setCreatedAt(brand.getCreatedAt());
            existingBrand.setUpdatedAt(brand.getUpdatedAt());
            Brands updatedBrand = brandsService.save(existingBrand);
            return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        System.out.println("=========>"+id);
        Optional<Brands> brandOptional = brandsService.findById(id);
        if (brandOptional.isPresent()) {
            brandsService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/{brandName}")
    public ResponseEntity<?> getBrandSearch(@PathVariable("brandName") String brandName) throws ApiMessage {
//        brandsService.getBrandsID(brandName);
        return new ResponseEntity<>(brandsService.getBrandsID(brandName), HttpStatus.OK);
    }
}
