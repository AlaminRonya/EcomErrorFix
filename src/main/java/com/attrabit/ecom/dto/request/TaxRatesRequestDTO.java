package com.attrabit.ecom.dto.request;

import com.attrabit.ecom.model.TaxClasses;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxRatesRequestDTO {

    private TaxClasses taxClass;

    private String country;

    private String state;

    private String city;

    private String zip;

    private BigDecimal rate;

    private Long position;

    // Constructor, getters and setters
}
