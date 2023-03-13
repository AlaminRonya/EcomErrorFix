package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.respose.ResponseProductDTO;
import com.attrabit.ecom.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponseProductDTOMapper implements Function<Products, ResponseProductDTO> {
    private final ResponseAttachmentDTOMapper responseAttachmentDTOMapper;
    @Override
    public ResponseProductDTO apply(Products products) {

        return (products  != null)? new ResponseProductDTO(
                products.getId(), products.getProductName(), (products.getBrand() != null) ? products.getBrand().getBrandName():null, products.getTaxClassId(), products.getSlug(),
                products.getPrice(), products.getSpecialPrice(), products.getSpecialPriceType(), products.getSpecialPriceStart(),
                products.getSpecialPriceEnd(), products.getSellingPrice(), products.getSku(), products.getManageStock(),
                products.getQty(), products.getInStock(), products.getViewed(), products.getIsActive(), products.getNewFrom(),
                products.getNewTo(), products.getDeletedAt(), products.getCreatedAt(), products.getUpdatedAt(), products.getVirtualAt(),
                (products.getProductAttachmentList() != null) ? products.getProductAttachmentList().stream().map(responseAttachmentDTOMapper).collect(Collectors.toList()) : null
        ) : null;
    }
}
