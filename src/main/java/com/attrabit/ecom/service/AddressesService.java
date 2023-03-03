package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.repository.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressesService {

    private final AddressesRepository addressesRepository;

    @Autowired
    public AddressesService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public List<Addresses> getAllAddresses() {
        return addressesRepository.findAll();
    }

    public Optional<Addresses> getAddressById(Long id) {
        return addressesRepository.findById(id);
    }

    public Addresses createAddress(Addresses address) {
        return addressesRepository.save(address);
    }

    public Addresses updateAddress(Long id, Addresses address) {
        Optional<Addresses> existingAddressOptional = addressesRepository.findById(id);

        if (existingAddressOptional.isEmpty()) {
            throw new IllegalArgumentException("Address with ID " + id + " not found.");
        }

        Addresses existingAddress = existingAddressOptional.get();
        existingAddress.setFirstName(address.getFirstName());
        existingAddress.setLastName(address.getLastName());
        existingAddress.setAddress1(address.getAddress1());
        existingAddress.setAddress2(address.getAddress2());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setZip(address.getZip());
        existingAddress.setCountry(address.getCountry());

        return addressesRepository.save(existingAddress);
    }

    public void deleteAddress(Long id) {
        addressesRepository.deleteById(id);
    }
}
