package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Activations;
import com.attrabit.ecom.service.ActivationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activations")
public class ActivationsController {
    @Autowired
    private ActivationsService activationsService;

    @GetMapping
    public List<Activations> getAllActivations() {
        return activationsService.getAllActivations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activations> getActivationById(@PathVariable("id") Long id) {
        Optional<Activations> optionalActivation = activationsService.getActivationById(id);
        return optionalActivation.map(activation -> new ResponseEntity<>(activation, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Activations> createActivation(@RequestBody Activations activation) {
        Activations createdActivation = activationsService.createActivation(activation);
        return new ResponseEntity<>(createdActivation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activations> updateActivation(@PathVariable("id") Long id, @RequestBody Activations activation) {
        Activations updatedActivation = activationsService.updateActivation(id, activation);
        return updatedActivation != null ? new ResponseEntity<>(updatedActivation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteActivation(@PathVariable("id") Long id) {
        activationsService.deleteActivation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
