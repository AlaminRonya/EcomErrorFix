package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.response.ResponseProductDTO;
import com.attrabit.ecom.model.Products;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
@Service
public class ComparedProductDTOMapper implements BiFunction<Products, ResponseProductDTO, Products> {
    @Override
    public Products apply(Products products, ResponseProductDTO dto) {
        if (dto.productName() != null && !dto.productName().isEmpty() && !dto.productName().equals(products.getProductName())){
            products.setProductName(dto.productName());
        }
        if (dto.slug() != null && !dto.slug().isEmpty() && !dto.slug().equals(products.getSku())){
            products.setSlug(dto.slug());
        }
        if (dto.price() != null && !dto.price().equals(products.getPrice())){
            products.setPrice(dto.price());
        }
        if (dto.specialPrice() != null && !dto.specialPrice().equals(products.getSpecialPrice())){
            products.setSpecialPrice(dto.specialPrice());
        }
        if (dto.specialPriceType() != null && !dto.specialPriceType().isEmpty() && !dto.specialPriceType().equals(products.getSpecialPriceType())) {
            products.setSpecialPriceType(dto.specialPriceType());
        }
        if (dto.specialPriceStart() != null && !dto.specialPriceStart().equals(products.getSpecialPriceStart())){
            products.setSpecialPriceStart(dto.specialPriceStart());
        }
        if (dto.specialPriceEnd() != null && !dto.specialPriceEnd().equals(products.getSpecialPriceEnd())) {
            products.setSpecialPriceEnd(dto.specialPriceEnd());
        }
        if (dto.sellingPrice() != null && !dto.sellingPrice().equals(products.getSellingPrice())){
            products.setSellingPrice(dto.sellingPrice());
        }
        if (dto.sku() != null && !dto.sku().isEmpty() && !dto.sku().equals(products.getSku())){
            products.setSku(dto.sku());
        }
        if (dto.manageStock() != null && !dto.manageStock().equals(products.getManageStock())){
            products.setManageStock(dto.manageStock());
        }
        if (dto.qty() != null && !dto.qty().equals(products.getQty())){
            products.setQty(dto.qty());
        }
        if (dto.inStock() != null && !dto.inStock().equals(products.getInStock())){
            products.setInStock(dto.inStock());
        }
        if (dto.viewed() != null && !dto.viewed().equals(products.getViewed())){
            products.setViewed(dto.viewed());
        }
        if (dto.isActive() != null && !dto.isActive().equals(products.getIsActive())){
            products.setIsActive(dto.isActive());
        }
        if (dto.newFrom() != null && !dto.newFrom().equals(products.getNewFrom())){
            products.setNewFrom(dto.newFrom());
        }
        if (dto.newTo() != null && !dto.newTo().equals(products.getNewTo())){
            products.setNewTo(dto.newTo());
        }
        if (dto.virtualAt() != null && !dto.virtualAt().equals(products.getVirtualAt())){
            products.setVirtualAt(dto.virtualAt());
        }
        products.setUpdatedAt(DateUtils.getDate());

        return products;
    }
}
