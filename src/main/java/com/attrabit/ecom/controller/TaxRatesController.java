package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.TaxRatesRequestDTO;
import com.attrabit.ecom.dto.response.TaxRatesResponseDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.model.TaxRates;
import com.attrabit.ecom.service.TaxRatesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tax-rates")
public class TaxRatesController {

    @Autowired
    private TaxRatesService taxRatesService;

    // Create operation
    @PostMapping
    public ResponseEntity<TaxRatesResponseDTO> createTaxRates(@RequestBody TaxRatesRequestDTO taxRatesRequestDTO) {
        TaxRates taxRates = taxRatesService.createTaxRates(taxRatesRequestDTO);
        TaxRatesResponseDTO taxRatesResponseDTO = new TaxRatesResponseDTO();
        BeanUtils.copyProperties(taxRates, taxRatesResponseDTO);
        return new ResponseEntity<>(taxRatesResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaxRatesResponseDTO>> getAllTaxRates() {
        List<TaxRates> taxRatesList = taxRatesService.getAllTaxRates();
        List<TaxRatesResponseDTO> taxRatesResponseDTOList = new ArrayList<>();
        for (TaxRates taxRates : taxRatesList) {
            TaxRatesResponseDTO taxRatesResponseDTO = new TaxRatesResponseDTO();
            BeanUtils.copyProperties(taxRates, taxRatesResponseDTO);
            taxRatesResponseDTOList.add(taxRatesResponseDTO);
        }
        return new ResponseEntity<>(taxRatesResponseDTOList, HttpStatus.OK);
    }

    // Read operation
    @GetMapping("/{id}")
    public ResponseEntity<TaxRatesResponseDTO> getTaxRatesById(@PathVariable Long id) throws ResourceNotFoundException {
        TaxRates taxRates = taxRatesService.getTaxRatesById(id);
        TaxRatesResponseDTO taxRatesResponseDTO = new TaxRatesResponseDTO();
        BeanUtils.copyProperties(taxRates, taxRatesResponseDTO);
        return new ResponseEntity<>(taxRatesResponseDTO, HttpStatus.OK);
    }

    // Update operation
    @PutMapping("/{id}")
    public ResponseEntity<TaxRatesResponseDTO> updateTaxRates(@PathVariable Long id, @RequestBody TaxRatesRequestDTO taxRatesRequestDTO) throws ResourceNotFoundException {
        TaxRates taxRates = taxRatesService.updateTaxRates(id, taxRatesRequestDTO);
        TaxRatesResponseDTO taxRatesResponseDTO = new TaxRatesResponseDTO();
        BeanUtils.copyProperties(taxRates, taxRatesResponseDTO);
        return new ResponseEntity<>(taxRatesResponseDTO, HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaxRates(@PathVariable Long id) throws ResourceNotFoundException {
        taxRatesService.deleteTaxRates(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
