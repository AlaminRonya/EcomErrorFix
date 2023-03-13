package com.attrabit.ecom.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CurrencyRatesRequestDTO {

    @NotBlank
    private String currency;

    @NotNull
    private Double rate;
}
