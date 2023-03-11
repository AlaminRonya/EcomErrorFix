package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.ResponseProductDTO;
import com.attrabit.ecom.exception.ApiMessage;

import java.util.List;

public interface ProductService {
    void addProduct(RequestProductDTO dto) throws ApiMessage;
    List<ResponseProductDTO> getAllProduct();
    ResponseProductDTO productSearch(String name) throws ApiMessage;
    void productDelete(String name) throws ApiMessage;
}
