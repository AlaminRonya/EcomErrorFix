package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.Response;
import com.attrabit.ecom.dto.response.ResponseProductDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.service.ProductSearchService;
import com.attrabit.ecom.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductSearchService productSearchService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestParam("image") MultipartFile[] multipartFiles, @RequestParam("dto") String dto) throws ApiMessage, JsonProcessingException {
//        System.out.println((multipartFiles[0]!=null)+"================"+ multipartFiles[0].isEmpty()+" == "+(multipartFiles[0]==null));
//        if (multipartFiles == null){
//            return new ResponseEntity<>("Not add product", HttpStatus.NO_CONTENT);
//        }


        if (multipartFiles[0].isEmpty()) {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("product","Not Add Product for image isEmpty"))
                            .message("Fail")
                            .status(BAD_REQUEST)
                            .statusCode(BAD_REQUEST.value())
                            .build()
            );
        }
        // TODO: 3/13/2023 multipartFile check
        ObjectMapper mapper = new ObjectMapper();
        final RequestProductDTO productDTO = mapper.readValue(dto, RequestProductDTO.class);
        productService.addProduct(multipartFiles,productDTO);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product","Add Product"))
                        .message("Success")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
//        return new ResponseEntity<>("Add product", HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody ResponseProductDTO dto) throws ApiMessage {

//        productService.updateProduct(dto);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productService.updateProduct(dto)))
                        .message("Success")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/product/all")
    public ResponseEntity<?> getAllProduct(){
        var allProduct = productService.getAllProduct();
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("allProduct",allProduct))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
//        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<?> getProduct(@PathVariable("productName") String productName) throws ApiMessage {
        var productSearch = productService.productSearch(productName);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productSearch))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
//        return new ResponseEntity<>(productService.productSearch(productName), HttpStatus.OK);
    }
    @DeleteMapping("/product/{productName}")
    public ResponseEntity<?> productDelete(@PathVariable("productName") String productName) throws ApiMessage {
        productService.productDelete(productName);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product","Deleted Product"))
                        .message("Success")
                        .status(NO_CONTENT)
                        .statusCode(NO_CONTENT.value())
                        .build()
        );
//        return new ResponseEntity<>("Deleted product", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/brand/{brandName}")
    public ResponseEntity<?> getBrandSearch(@PathVariable("brandName") String brandName) throws ApiMessage {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("brandProduct",productSearchService.getSearchBrandProduct(brandName)))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/product/category/{categoryName}")
    public ResponseEntity<?> getCategorySearch(@PathVariable("categoryName") String categoryName){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("categoryProduct",productSearchService.getSearchSlugProduct(categoryName)))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
