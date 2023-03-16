package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestTaxClassesDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.service.TaxClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class TaxClassesController {
    private final TaxClassesService taxClassesService;
    @PostMapping("/taxClasses")
    public ResponseEntity<?> addTaxClasses(@RequestBody RequestTaxClassesDTO dto) throws ApiMessage {
        final Long taxClassesID = taxClassesService.addTaxClasses(dto);
        return new ResponseEntity<>("Add TaxClasses: "+taxClassesID, HttpStatus.CREATED);
    }
    @GetMapping("/taxClasses")
    public ResponseEntity<?> getAllTaxClasses() throws ApiMessage {
        return new ResponseEntity<>(taxClassesService.getAllTaxClasses(), HttpStatus.OK);
    }

}
