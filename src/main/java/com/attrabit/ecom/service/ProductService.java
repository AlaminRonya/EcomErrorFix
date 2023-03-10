package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.ResponseProductDTO;

import java.util.List;

public interface ProductService {
    void addProduct(RequestProductDTO dto);
    List<ResponseProductDTO> getAllProduct();
}
