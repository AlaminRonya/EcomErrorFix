package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestTaxClassesDTO;
import com.attrabit.ecom.dto.response.ResponseTaxClassesDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.TaxClasses;

import java.util.List;

public interface TaxClassesService {
    Long addTaxClasses(RequestTaxClassesDTO dto) throws ApiMessage;
    TaxClasses getTaxClasses(String basedOn) throws ApiMessage;
    List<ResponseTaxClassesDTO> getAllTaxClasses() throws ApiMessage;
}
