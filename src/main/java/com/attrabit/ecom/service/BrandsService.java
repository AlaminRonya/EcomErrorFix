package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.AuthenticationRequest;
import com.attrabit.ecom.dto.respose.AuthenticationResponse;
import com.attrabit.ecom.exception.ApiException;
import com.attrabit.ecom.exception.ApiMessage;
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

    public Brands save(Brands brands) throws ApiMessage {
        try {
            return brandsRepository.save(brands);
        }catch (Exception e){
            throw new ApiMessage("Already brands exited!");
        }

    }

    public void deleteById(Long id) {
        brandsRepository.deleteById(id);
    }


}
