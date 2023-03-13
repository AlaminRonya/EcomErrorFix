package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Options;
import com.attrabit.ecom.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/options")
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @GetMapping
    public ResponseEntity<List<Options>> getAllOptions() {
        List<Options> optionsList = optionsService.getAllOptions();
        return new ResponseEntity<>(optionsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Options> getOptionsById(@PathVariable Long id) {
        Optional<Options> options = optionsService.getOptionsById(id);
        return options.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Options> createOptions(@RequestBody Options options) {
        Options createdOptions = optionsService.createOptions(options);
        return new ResponseEntity<>(createdOptions, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Options> updateOptions(@PathVariable Long id, @RequestBody Options options) {
        Options updatedOptions = optionsService.updateOptions(id, options);
        return new ResponseEntity<>(updatedOptions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOptions(@PathVariable Long id) {
        optionsService.deleteOptions(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
