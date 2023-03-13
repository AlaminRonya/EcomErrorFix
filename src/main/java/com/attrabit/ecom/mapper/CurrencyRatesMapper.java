package com.attrabit.ecom.mapper;


import com.attrabit.ecom.dto.request.CurrencyRatesRequestDTO;
import com.attrabit.ecom.dto.response.CurrencyRatesResponseDTO;
import com.attrabit.ecom.model.CurrencyRates;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class CurrencyRatesMapper implements Function<CurrencyRatesRequestDTO, CurrencyRates> {

    @Override
    public CurrencyRates apply(CurrencyRatesRequestDTO dto) {
        CurrencyRates currencyRates = new CurrencyRates();
        currencyRates.setCurrency(dto.getCurrency());
        currencyRates.setRate(dto.getRate());
        currencyRates.setCreatedAt(DateUtils.getDate());
        currencyRates.setUpdatedAt(DateUtils.getDate());
        return currencyRates;
    }

    public CurrencyRatesResponseDTO mapToResponseDTO(CurrencyRates currencyRates) {
        return getCurrencyRateResponseDTO(currencyRates);
    }

    public CurrencyRates toEntity(CurrencyRatesRequestDTO requestDTO) {
        CurrencyRates entity = new CurrencyRates();
        entity.setCurrency(requestDTO.getCurrency());
        entity.setRate(requestDTO.getRate());
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        return entity;
    }

    public CurrencyRatesResponseDTO toResponseDTO(CurrencyRates entity) {
        return getCurrencyRateResponseDTO(entity);
    }

    private CurrencyRatesResponseDTO getCurrencyRateResponseDTO(CurrencyRates entity) {
        CurrencyRatesResponseDTO responseDTO = new CurrencyRatesResponseDTO();
        responseDTO.setId(entity.getId());
        responseDTO.setCurrency(entity.getCurrency());
        responseDTO.setRate(entity.getRate());
        responseDTO.setCreatedAt(entity.getCreatedAt());
        responseDTO.setUpdatedAt(entity.getUpdatedAt());
        return responseDTO;
    }

}
