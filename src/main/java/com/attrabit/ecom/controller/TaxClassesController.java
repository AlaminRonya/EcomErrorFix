package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.RequestTaxClassesDTO;
import com.attrabit.ecom.dto.response.Response;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.service.TaxClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:4200")
public class TaxClassesController {
    private final TaxClassesService taxClassesService;
    @PostMapping("/taxClasses")
    public ResponseEntity<?> addTaxClasses(@RequestBody RequestTaxClassesDTO dto) throws ApiMessage {
        final Long taxClassesID = taxClassesService.addTaxClasses(dto);
//        return new ResponseEntity<>("Add TaxClasses: "+taxClassesID, HttpStatus.CREATED);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("taxClass","Insert"))
                        .message("Success")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("/taxClasses")
    public ResponseEntity<?> getAllTaxClasses() throws ApiMessage {
//        return new ResponseEntity<>(taxClassesService.getAllTaxClasses(), HttpStatus.OK);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("taxClasses",taxClassesService.getAllTaxClasses()))
                        .message("Success")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
