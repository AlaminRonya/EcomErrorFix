package com.attrabit.ecom.dto.response;

import com.attrabit.ecom.model.TaxClasses;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TaxRatesResponseDTO {

    private Long id;

    private TaxClasses taxClass;

    private String country;

    private String state;

    private String city;

    private String zip;

    private BigDecimal rate;

    private Long position;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    // Constructor, getters and setters
}
