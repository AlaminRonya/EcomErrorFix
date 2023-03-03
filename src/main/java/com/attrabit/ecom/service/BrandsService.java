package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.repository.BrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public List<Brands> findAll() {
        return brandsRepository.findAll();
    }

    public Optional<Brands> findById(Long id) {
        return brandsRepository.findById(id);
    }

    public Brands save(Brands brands) {
        return brandsRepository.save(brands);
    }

    public void deleteById(Long id) {
        brandsRepository.deleteById(id);
    }
}
