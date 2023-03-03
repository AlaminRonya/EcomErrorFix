package com.attrabit.ecom.service;

import com.attrabit.ecom.model.DefaultAddress;
import com.attrabit.ecom.repository.DefaultAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAddressService {

    @Autowired
    private DefaultAddressRepository defaultAddressRepository;

    public List<DefaultAddress> getAllDefaultAddresses() {
        return defaultAddressRepository.findAll();
    }

    public DefaultAddress getDefaultAddressById(Long id) {
        return defaultAddressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Default Address not found with id: " + id));
    }

    public DefaultAddress saveDefaultAddress(DefaultAddress defaultAddress) {
        return defaultAddressRepository.save(defaultAddress);
    }

    public void deleteDefaultAddressById(Long id) {
        defaultAddressRepository.deleteById(id);
    }
}
