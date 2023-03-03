package com.attrabit.ecom.service;

import com.attrabit.ecom.model.CrossSellProducts;
import com.attrabit.ecom.repository.CrossSellProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrossSellProductsService {

    private final CrossSellProductsRepository crossSellProductsRepository;

    @Autowired
    public CrossSellProductsService(CrossSellProductsRepository crossSellProductsRepository) {
        this.crossSellProductsRepository = crossSellProductsRepository;
    }

    public List<CrossSellProducts> getAllCrossSellProducts() {
        return crossSellProductsRepository.findAll();
    }

    public CrossSellProducts getCrossSellProductById(Long id) {
        return crossSellProductsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid CrossSellProduct id: " + id));
    }

    public CrossSellProducts saveCrossSellProduct(CrossSellProducts crossSellProduct) {
        return crossSellProductsRepository.save(crossSellProduct);
    }

    public void deleteCrossSellProduct(CrossSellProducts crossSellProduct) {
        crossSellProductsRepository.delete(crossSellProduct);
    }
}
