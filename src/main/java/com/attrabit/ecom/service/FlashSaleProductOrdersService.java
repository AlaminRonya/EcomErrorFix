package com.attrabit.ecom.service;

import com.attrabit.ecom.model.FlashSaleProductOrders;
import com.attrabit.ecom.repository.FlashSaleProductOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlashSaleProductOrdersService {

    @Autowired
    private FlashSaleProductOrdersRepository flashSaleProductOrdersRepository;

    public FlashSaleProductOrders saveFlashSaleProductOrder(FlashSaleProductOrders flashSaleProductOrder) {
        return flashSaleProductOrdersRepository.save(flashSaleProductOrder);
    }

    // other service methods
    // ...
}
