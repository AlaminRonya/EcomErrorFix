package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.respose.ResponseProductDTO;
import com.attrabit.ecom.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductSearchService {
    List<ResponseProductDTO> getSearchSlugProduct(String slug);
    List<ResponseProductDTO> getSearchBrandProduct(String brandName);

}
