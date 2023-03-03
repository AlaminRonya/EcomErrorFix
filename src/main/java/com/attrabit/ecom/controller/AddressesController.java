package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressesController {

    private final AddressesService addressesService;

    @Autowired
    public AddressesController(AddressesService addressesService) {
        this.addressesService = addressesService;
    }

    @GetMapping
    public ResponseEntity<List<Addresses>> getAllAddresses() {
        List<Addresses> addresses = addressesService.getAllAddresses();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addresses> getAddressById(@PathVariable Long id) {
        Optional<Addresses> addressOptional = addressesService.getAddressById(id);

        if (addressOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Addresses address = addressOptional.get();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Addresses> createAddress(@RequestBody Addresses address) {
        Addresses createdAddress = addressesService.createAddress(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addresses> updateAddress(@PathVariable Long id, @RequestBody Addresses address) {
        Addresses updatedAddress = addressesService.updateAddress(id, address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable Long id) {
        addressesService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
