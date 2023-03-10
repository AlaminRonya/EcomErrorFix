package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.ResponseProductDTO;
import com.attrabit.ecom.mapper.RequestProductDTOMapper;
import com.attrabit.ecom.mapper.ResponseProductDTOMapper;
import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.model.Products;
import com.attrabit.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final RequestProductDTOMapper requestProductDTOMapper;
    private final ResponseProductDTOMapper responseProductDTOMapper;
    private final BrandSearchService brandSearchService;
    private final ProductRepository productRepository;
    @Override
    public void addProduct(RequestProductDTO dto) {
        try {
            final Products products = requestProductDTOMapper.apply(dto);
            final Brands brands = brandSearchService.getBrandsID(dto.brand());
            products.setBrand(brands);
            productRepository.save(products);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ResponseProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(responseProductDTOMapper).toList();
    }
}
