package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Coupons;
import com.attrabit.ecom.repository.CouponsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponsService {

    private final CouponsRepository couponsRepository;

    @Autowired
    public CouponsService(CouponsRepository couponsRepository) {
        this.couponsRepository = couponsRepository;
    }

    public Coupons save(Coupons coupons) {
        return couponsRepository.save(coupons);
    }

    public Optional<Coupons> findById(Long id) {
        return couponsRepository.findById(id);
    }

    public List<Coupons> findAll() {
        return couponsRepository.findAll();
    }

    public void deleteById(Long id) {
        couponsRepository.deleteById(id);
    }
}
