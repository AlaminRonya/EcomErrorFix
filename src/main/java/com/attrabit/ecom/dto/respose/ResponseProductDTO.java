package com.attrabit.ecom.dto.respose;

import java.math.BigDecimal;
import java.util.Date;

public record ResponseProductDTO(
        Long id,String brand,Long taxClassId,String slug,BigDecimal price,BigDecimal specialPrice,
        String specialPriceType, Date specialPriceStart,Date specialPriceEnd, BigDecimal sellingPrice,
        String sku,Boolean manageStock,Integer qty,Boolean inStock,Long viewed, Boolean isActive,
        Date newFrom,Date newTo,Date deletedAt,Date createdAt,Date updatedAt,Boolean virtualAt
) {
}
