package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestTaxClassesDTO;
import com.attrabit.ecom.dto.response.ResponseTaxClassesDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.mapper.ResponseTaxClassesDTOMapper;
import com.attrabit.ecom.model.TaxClasses;
import com.attrabit.ecom.repository.TaxClassesRepository;
import com.attrabit.ecom.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaxClassesServiceImpl implements TaxClassesService{
    private final TaxClassesRepository taxClassesRepository;
    private final ResponseTaxClassesDTOMapper responseTaxClassesDTOMapper;
    @Override
    public Long addTaxClasses(RequestTaxClassesDTO dto) throws ApiMessage{
        try {
            final TaxClasses taxClasses = searchBasedOn(dto.basedOn());
            if (taxClasses != null){
                throw new ApiMessage("Already exited!");
            }
            TaxClasses tax = new TaxClasses();
            tax.setBasedOn(dto.basedOn().toUpperCase());
            tax.setCreatedAt(DateUtils.getDate());

            return taxClassesRepository.save(tax).getId();

        }catch (Exception e){
            throw new ApiMessage("Internal error");
        }
    }

    @Override
    public TaxClasses getTaxClasses(String basedOn) throws ApiMessage {
        try {
            final TaxClasses taxClasses = searchBasedOn(basedOn);
            if (taxClasses == null){
                throw new ApiMessage("No search");
            }
            return taxClasses;
        }catch (Exception e){
            throw new ApiMessage("Internal Error");
        }
    }

    @Override
    public List<ResponseTaxClassesDTO> getAllTaxClasses() throws ApiMessage {
        return taxClassesRepository.findAll().stream().map(responseTaxClassesDTOMapper).toList();
    }

    private TaxClasses searchBasedOn(String basedOn){
        return taxClassesRepository.findByBasedOn(basedOn.toUpperCase()).orElse(null);
    }
}
