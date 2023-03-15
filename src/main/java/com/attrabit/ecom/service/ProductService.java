package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.response.ResponseProductDTO;
import com.attrabit.ecom.exception.ApiMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    void addProduct(MultipartFile[] multipartFiles, RequestProductDTO dto) throws ApiMessage;
    List<ResponseProductDTO> getAllProduct();
    ResponseProductDTO productSearch(String name) throws ApiMessage;
    void productDelete(String name) throws ApiMessage;

    ResponseProductDTO updateProduct(ResponseProductDTO dto) throws ApiMessage;
}
