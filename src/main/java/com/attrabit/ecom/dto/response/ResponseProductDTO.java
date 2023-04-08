package com.attrabit.ecom.dto.response;
import com.attrabit.ecom.dto.response.ResponseAttachmentDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record ResponseProductDTO(
        Long id, String productName,String brand,Long taxClassId,String slug,BigDecimal price,BigDecimal specialPrice,
        String specialPriceType, Date specialPriceStart,Date specialPriceEnd, BigDecimal sellingPrice,
        String sku,Boolean manageStock,Integer qty,Boolean inStock,Long viewed, Boolean isActive,
        Date newFrom,Date newTo,Date deletedAt,Date createdAt,Date updatedAt,Boolean virtualAt,
        List<ResponseAttachmentDTO> attachmentDTOList
) {
}
