package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.model.Products;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class RequestProductDTOMapper implements Function<RequestProductDTO, Products> {
    @Override
    public Products apply(RequestProductDTO dto) {
        Products products = new Products();

        products.setSlug(dto.slug());
        products.setPrice(dto.price());
        products.setSpecialPrice(dto.specialPrice());
        products.setSpecialPriceType(dto.specialPriceType());
        products.setSpecialPriceEnd(dto.specialPriceStart());
        products.setSpecialPriceEnd(dto.specialPriceEnd());
        products.setSellingPrice(dto.sellingPrice());
        products.setSku(dto.sku());
        products.setManageStock(dto.manageStock());
        products.setInStock(dto.inStock());
        products.setViewed(dto.viewed());
        products.setIsActive(dto.isActive());
        products.setNewFrom(dto.newFrom());
        products.setNewTo(dto.newTo());
        products.setCreatedAt(DateUtils.getDate());
        products.setVirtualAt(dto.virtualAt());

        return products;
    }
}
