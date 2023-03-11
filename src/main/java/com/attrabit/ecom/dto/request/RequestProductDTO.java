package com.attrabit.ecom.dto.request;


import java.math.BigDecimal;
import java.util.Date;

public record RequestProductDTO(
        String productName, String brand,Long taxClassId,String slug,BigDecimal price,BigDecimal specialPrice,
        String specialPriceType, Date specialPriceStart,Date specialPriceEnd, BigDecimal sellingPrice,
        String sku,Boolean manageStock,Integer qty,Boolean inStock,Long viewed, Boolean isActive,
        Date newFrom,Date newTo, Boolean virtualAt
) {
}
