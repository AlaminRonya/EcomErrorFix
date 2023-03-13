package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.Response;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestParam("image") MultipartFile[] multipartFiles, @RequestParam("dto") String dto) throws ApiMessage, JsonProcessingException {
//        System.out.println("================"+multipartFiles.getClass());
//        if (multipartFiles == null){
//            return new ResponseEntity<>("Not add product", HttpStatus.NO_CONTENT);
//        }
        // TODO: 3/13/2023 multipartFile check
        ObjectMapper mapper = new ObjectMapper();
        final RequestProductDTO productDTO = mapper.readValue(dto, RequestProductDTO.class);
        productService.addProduct(multipartFiles,productDTO);
        return new ResponseEntity<>("Add product", HttpStatus.CREATED);
    }

    @GetMapping("/product/all")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<?> getProduct(@PathVariable("productName") String productName) throws ApiMessage {

        return new ResponseEntity<>(productService.productSearch(productName), HttpStatus.OK);
    }
    @DeleteMapping("/product/{productName}")
    public ResponseEntity<?> productDelete(@PathVariable("productName") String productName) throws ApiMessage {
        productService.productDelete(productName);
        return new ResponseEntity<>("Deleted product", HttpStatus.NO_CONTENT);
    }

}
