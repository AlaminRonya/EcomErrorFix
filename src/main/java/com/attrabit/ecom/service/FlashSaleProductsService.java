package com.attrabit.ecom.service;

import com.attrabit.ecom.model.FlashSaleProducts;
import com.attrabit.ecom.repository.FlashSaleProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashSaleProductsService {

    @Autowired
    private FlashSaleProductsRepository flashSaleProductsRepository;

    public List<FlashSaleProducts> getAllFlashSaleProducts() {
        return flashSaleProductsRepository.findAll();
    }

    public Optional<FlashSaleProducts> getFlashSaleProductById(Long id) {
        return flashSaleProductsRepository.findById(id);
    }

    public FlashSaleProducts saveFlashSaleProduct(FlashSaleProducts flashSaleProduct) {
        return flashSaleProductsRepository.save(flashSaleProduct);
    }

    public void deleteFlashSaleProductById(Long id) {
        flashSaleProductsRepository.deleteById(id);
    }

}
