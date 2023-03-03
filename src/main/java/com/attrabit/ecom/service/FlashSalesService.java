package com.attrabit.ecom.service;

import com.attrabit.ecom.model.FlashSales;
import com.attrabit.ecom.repository.FlashSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashSalesService {

    @Autowired
    private FlashSalesRepository flashSalesRepository;

    public List<FlashSales> getAllFlashSales() {
        return flashSalesRepository.findAll();
    }

    public Optional<FlashSales> getFlashSalesById(Long id) {
        return flashSalesRepository.findById(id);
    }

    public FlashSales saveFlashSales(FlashSales flashSales) {
        return flashSalesRepository.save(flashSales);
    }

    public void deleteFlashSalesById(Long id) {
        flashSalesRepository.deleteById(id);
    }
}
