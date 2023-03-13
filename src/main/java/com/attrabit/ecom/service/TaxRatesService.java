package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.TaxRatesRequestDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.model.TaxRates;
import com.attrabit.ecom.repository.TaxRatesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaxRatesService {

    @Autowired
    private TaxRatesRepository taxRatesRepository;

    public TaxRates createTaxRates(TaxRatesRequestDTO taxRatesRequestDTO) {
        TaxRates taxRates = new TaxRates();
        BeanUtils.copyProperties(taxRatesRequestDTO, taxRates);
        taxRates.setCreatedAt(new Date());
        taxRates.setUpdatedAt(new Date());
        return taxRatesRepository.save(taxRates);
    }

    public List<TaxRates> getAllTaxRates() {
        return taxRatesRepository.findAll();
    }

    public TaxRates getTaxRatesById(Long id) throws ResourceNotFoundException {
        Optional<TaxRates> optionalTaxRates = taxRatesRepository.findById(id);
        if (optionalTaxRates.isPresent()) {
            return optionalTaxRates.get();
        } else {
            throw new ResourceNotFoundException("TaxRates not found with id: " + id);
        }
    }

    public TaxRates updateTaxRates(Long id, TaxRatesRequestDTO taxRatesRequestDTO) throws ResourceNotFoundException {
        Optional<TaxRates> optionalTaxRates = taxRatesRepository.findById(id);
        if (optionalTaxRates.isPresent()) {
            TaxRates taxRates = optionalTaxRates.get();
            BeanUtils.copyProperties(taxRatesRequestDTO, taxRates, "id", "createdAt", "updatedAt", "deletedAt");
            taxRates.setUpdatedAt(new Date());
            return taxRatesRepository.save(taxRates);
        } else {
            throw new ResourceNotFoundException("TaxRates not found with id: " + id);
        }
    }

    public void deleteTaxRates(Long id) throws ResourceNotFoundException {
        Optional<TaxRates> optionalTaxRates = taxRatesRepository.findById(id);
        if (optionalTaxRates.isPresent()) {
            TaxRates taxRates = optionalTaxRates.get();
            taxRates.setDeletedAt(new Date());
            taxRatesRepository.save(taxRates);
        } else {
            throw new ResourceNotFoundException("TaxRates not found with id: " + id);
        }
    }
}
