package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Attributes;
import com.attrabit.ecom.service.AttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attributes")
public class AttributesController {

    @Autowired
    private AttributesService attributesService;

    @GetMapping
    public ResponseEntity<List<Attributes>> getAllAttributes() {
        List<Attributes> attributesList = attributesService.getAllAttributes();
        return new ResponseEntity<>(attributesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attributes> getAttributeById(@PathVariable Long id) {
        Optional<Attributes> optionalAttribute = attributesService.getAttributeById(id);
        return optionalAttribute.map(attribute -> new ResponseEntity<>(attribute, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Attributes> createAttribute(@RequestBody Attributes attribute) {
        Attributes createdAttribute = attributesService.createAttribute(attribute);
        return new ResponseEntity<>(createdAttribute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attributes> updateAttribute(@PathVariable Long id, @RequestBody Attributes attribute) {
        Attributes updatedAttribute = attributesService.updateAttribute(id, attribute);
        return updatedAttribute != null ? new ResponseEntity<>(updatedAttribute, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable Long id) {
        attributesService.deleteAttribute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
