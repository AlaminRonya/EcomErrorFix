package com.attrabit.ecom.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CurrencyRatesResponseDTO {

    private Long id;

    private String currency;

    private Double rate;

    private Date createdAt;

    private Date updatedAt;
}

