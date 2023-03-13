package com.attrabit.ecom.controller;

import com.attrabit.ecom.dto.request.CurrencyRatesRequestDTO;
import com.attrabit.ecom.dto.response.CurrencyRatesResponseDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.service.CurrencyRatesService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/currency-rates")
public class CurrencyRatesController {

    private final CurrencyRatesService currencyRatesService;

    @Autowired
    public CurrencyRatesController(CurrencyRatesService currencyRatesService) {
        this.currencyRatesService = currencyRatesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrencyRatesResponseDTO> getCurrencyRateById(@PathVariable Long id) throws ResourceNotFoundException {
        CurrencyRatesResponseDTO currencyRatesResponseDTO = currencyRatesService.getCurrencyRateById(id);
        return ResponseEntity.ok(currencyRatesResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CurrencyRatesResponseDTO>> getAllCurrencyRates() {
        List<CurrencyRatesResponseDTO> currencyRatesResponseDTOS = currencyRatesService.getAllCurrencyRates();
        return ResponseEntity.ok(currencyRatesResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<CurrencyRatesResponseDTO> createCurrencyRate(@Valid @RequestBody CurrencyRatesRequestDTO currencyRatesRequestDTO) {
        CurrencyRatesResponseDTO currencyRatesResponseDTO = currencyRatesService.createCurrencyRate(currencyRatesRequestDTO);
        return ResponseEntity.created(URI.create("/api/currency-rates/" + currencyRatesResponseDTO.getId()))
                .body(currencyRatesResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyRatesResponseDTO> updateCurrencyRate(@PathVariable Long id, @Valid @RequestBody CurrencyRatesRequestDTO currencyRatesRequestDTO) throws ResourceNotFoundException {
        CurrencyRatesResponseDTO currencyRatesResponseDTO = currencyRatesService.updateCurrencyRate(id, currencyRatesRequestDTO);
        return ResponseEntity.ok(currencyRatesResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrencyRate(@PathVariable Long id) throws ResourceNotFoundException {
        currencyRatesService.deleteCurrencyRate(id);
        return ResponseEntity.noContent().build();
    }
}
