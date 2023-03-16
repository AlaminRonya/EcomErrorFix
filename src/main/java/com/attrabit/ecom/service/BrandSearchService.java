package com.attrabit.ecom.service;

import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Brands;

public interface BrandSearchService {
    Brands getBrandsID(String brandName) throws ApiMessage;
}
