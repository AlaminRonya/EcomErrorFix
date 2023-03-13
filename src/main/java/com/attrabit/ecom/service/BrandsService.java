package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestBrandsDTO;
import com.attrabit.ecom.dto.response.ResponseBrandsDTO;
import com.attrabit.ecom.exception.ResourceNotFoundException;
import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.repository.BrandsRepository;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandsService {

    private BrandsRepository brandsRepository;

    @Autowired
    public BrandsService(BrandsRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    public ResponseBrandsDTO getBrandById(Long id) throws ResourceNotFoundException {
        Brands brand = brandsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this id: " + id));
        return convertToDto(brand);
    }

    public List<ResponseBrandsDTO> getAllBrands() {
        List<Brands> brands = brandsRepository.findAll();
        return brands.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ResponseBrandsDTO createBrand(RequestBrandsDTO dto) {
        System.out.println(dto);

        Brands brand = new Brands();
        brand.setBrandName(dto.brandName());
        brand.setSlug(dto.slug());
        brand.setCreatedAt(DateUtils.getDate());
        brand.setIsActive(dto.isActive());

        Brands save = brandsRepository.save(brand);

        return null;
    }

    public ResponseBrandsDTO updateBrand(Long id, RequestBrandsDTO requestBrandsDTO) throws ResourceNotFoundException {
        Brands brand = brandsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this id: " + id));

        brand.setBrandName(requestBrandsDTO.brandName());
        brand.setSlug(requestBrandsDTO.slug());
        brand.setIsActive(requestBrandsDTO.isActive());
        brand = brandsRepository.save(brand);

        return convertToDto(brand);
    }

    public void deleteBrand(Long id) throws ResourceNotFoundException {
        Brands brand = brandsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found for this id: " + id));
        brandsRepository.delete(brand);
    }

    private ResponseBrandsDTO convertToDto(Brands brand) {
        return new ResponseBrandsDTO(
                brand.getId(),
                brand.getBrandName(),
                brand.getSlug(),
                brand.getIsActive(),
                brand.getCreatedAt(),
                brand.getUpdatedAt()
        );
    }

    public List<ResponseBrandsDTO> searchBrandByName(String name) {
        Optional<Brands> brands = brandsRepository.findByBrandName(name);
        return brands.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
