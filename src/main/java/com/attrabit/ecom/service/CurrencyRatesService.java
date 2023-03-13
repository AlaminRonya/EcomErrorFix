package com.attrabit.ecom.service;


import com.attrabit.ecom.dto.request.CurrencyRatesRequestDTO;
import com.attrabit.ecom.dto.response.CurrencyRatesResponseDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.mapper.CurrencyRatesMapper;
import com.attrabit.ecom.model.CurrencyRates;
import com.attrabit.ecom.repository.CurrencyRatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CurrencyRatesService {

    private final CurrencyRatesRepository currencyRatesRepository;
    private final CurrencyRatesMapper currencyRatesMapper;

    @Autowired
    public CurrencyRatesService(CurrencyRatesRepository currencyRatesRepository, CurrencyRatesMapper currencyRatesMapper) {
        this.currencyRatesRepository = currencyRatesRepository;
        this.currencyRatesMapper = currencyRatesMapper;
    }

    public CurrencyRatesResponseDTO getCurrencyRateById(Long id) throws ResourceNotFoundException {
        CurrencyRates currencyRates = currencyRatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency rate not found with id " + id));
        return currencyRatesMapper.toResponseDTO(currencyRates);
    }

    public List<CurrencyRatesResponseDTO> getAllCurrencyRates() {
        List<CurrencyRates> currencyRates = currencyRatesRepository.findAll();
        List<CurrencyRatesResponseDTO> currencyRatesResponseDTOList = new ArrayList<>();
        for (CurrencyRates c: currencyRates){
            currencyRatesResponseDTOList.add(currencyRatesMapper.toResponseDTO(c));
        }
        return currencyRatesResponseDTOList;
//        return currencyRateMapper.toResponseDTO(currencyRate);
    }

    public CurrencyRatesResponseDTO createCurrencyRate(CurrencyRatesRequestDTO currencyRatesRequestDTO) {
        CurrencyRates currencyRates = currencyRatesMapper.toEntity(currencyRatesRequestDTO);
        currencyRates.setCreatedAt(new Date());
        currencyRatesRepository.save(currencyRates);
        return currencyRatesMapper.toResponseDTO(currencyRates);
    }

    public CurrencyRatesResponseDTO updateCurrencyRate(Long id, CurrencyRatesRequestDTO currencyRatesRequestDTO) throws ResourceNotFoundException {
        CurrencyRates currencyRates = currencyRatesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency rate not found with id " + id));
        currencyRates.setCurrency(currencyRatesRequestDTO.getCurrency());
        currencyRates.setRate(currencyRatesRequestDTO.getRate());
        currencyRates.setUpdatedAt(new Date());
        currencyRatesRepository.save(currencyRates);
        return currencyRatesMapper.toResponseDTO(currencyRates);
    }

    public void deleteCurrencyRate(Long id) throws ResourceNotFoundException {
        if (!currencyRatesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Currency rate not found with id " + id);
        }
        currencyRatesRepository.deleteById(id);
    }
}
