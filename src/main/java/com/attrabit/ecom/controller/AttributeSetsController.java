package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.AttributeSets;
import com.attrabit.ecom.service.AttributeSetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attribute-sets")
public class AttributeSetsController {

    private final AttributeSetsService attributeSetsService;

    @Autowired
    public AttributeSetsController(AttributeSetsService attributeSetsService) {
        this.attributeSetsService = attributeSetsService;
    }

    @GetMapping("")
    public ResponseEntity<List<AttributeSets>> getAllAttributeSets() {
        List<AttributeSets> attributeSets = attributeSetsService.getAllAttributeSets();
        return new ResponseEntity<>(attributeSets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeSets> getAttributeSetById(@PathVariable Long id) {
        Optional<AttributeSets> attributeSet = attributeSetsService.getAttributeSetById(id);
        return attributeSet.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<AttributeSets> createAttributeSet(@RequestBody AttributeSets attributeSet) {
        AttributeSets savedAttributeSet = attributeSetsService.saveAttributeSet(attributeSet);
        return new ResponseEntity<>(savedAttributeSet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAttributeSetById(@PathVariable Long id) {
        attributeSetsService.deleteAttributeSetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
