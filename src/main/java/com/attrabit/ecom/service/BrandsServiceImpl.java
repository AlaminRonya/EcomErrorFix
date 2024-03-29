package com.attrabit.ecom.service;

import com.attrabit.ecom.exception.ApiException;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.repository.BrandsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
@RequiredArgsConstructor
public class BrandsServiceImpl implements BrandSearchService{

    private final BrandsRepository brandsRepository;

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


    @Override
    public Brands getBrandsID(String brandName) throws ApiMessage {
//        final Brands brands = searchByBrandsName(brandName);
        return searchByBrandsName(brandName);
    }

    private Brands searchByBrandsName(String brandName) throws ApiMessage {
        try {
            final Brands brands = brandsRepository.findByBrandName(brandName).orElse(null);
            if (brands == null){
                throw new ApiMessage("No Search brand");
            }
            return brands;
        }catch (Exception e){
           throw new ApiMessage("Internal error");
        }
    }
}
