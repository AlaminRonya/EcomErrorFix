package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.AttributeValues;
import com.attrabit.ecom.service.AttributeValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attributeValues")
public class AttributeValuesController {

    private final AttributeValuesService attributeValuesService;

    @Autowired
    public AttributeValuesController(AttributeValuesService attributeValuesService) {
        this.attributeValuesService = attributeValuesService;
    }

    @GetMapping
    public ResponseEntity<List<AttributeValues>> getAllAttributeValues() {
        List<AttributeValues> attributeValues = attributeValuesService.getAllAttributeValues();
        return new ResponseEntity<>(attributeValues, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeValues> getAttributeValuesById(@PathVariable("id") Long id) {
        Optional<AttributeValues> attributeValues = attributeValuesService.getAttributeValuesById(id);
        return attributeValues.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AttributeValues> saveAttributeValues(@RequestBody AttributeValues attributeValues) {
        AttributeValues savedAttributeValues = attributeValuesService.saveAttributeValues(attributeValues);
        return new ResponseEntity<>(savedAttributeValues, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAttributeValuesById(@PathVariable("id") Long id) {
        attributeValuesService.deleteAttributeValuesById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
