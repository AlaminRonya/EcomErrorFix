package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestProductDTO;
import com.attrabit.ecom.dto.respose.ResponseAttachmentDTO;
import com.attrabit.ecom.dto.respose.ResponseProductDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.files.FileService;
import com.attrabit.ecom.mapper.RequestProductDTOMapper;
import com.attrabit.ecom.mapper.ResponseAttachmentDTOMapper;
import com.attrabit.ecom.mapper.ResponseProductDTOMapper;
import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.model.Brands;
import com.attrabit.ecom.model.Products;
import com.attrabit.ecom.repository.AttachmentRepository;
import com.attrabit.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService, ProductSearchService{
    private final RequestProductDTOMapper requestProductDTOMapper;
    private final ResponseProductDTOMapper responseProductDTOMapper;
    private final BrandSearchService brandSearchService;
    private final ProductRepository productRepository;
    private final FilesService filesService;
    private final FileService fileService;
    private final AttachmentRepository attachmentRepository;
    private final ResponseAttachmentDTOMapper responseAttachmentDTOMapper;
    @Override
    public void addProduct(MultipartFile[] multipartFiles, RequestProductDTO dto) throws ApiMessage  {
        try {
            if (searchProductName(dto.productName()) != null){
                throw new ApiMessage("Already product exit!");
            }
            List<Attachment> attachments = new ArrayList<>();
            for (MultipartFile file : multipartFiles){
                attachments.add(fileService.uploadImage("D:/Attrabit/Nafi/Second/ecom/src/main/resources/static/productImages", file));
            }
            final List<Attachment> attachmentList = attachmentRepository.saveAll(attachments);

            // TODO: 3/11/2023 checking taxClasses ID
            final Products products = requestProductDTOMapper.apply(dto);
            final Brands brands = brandSearchService.getBrandsID(dto.brand());
            products.setBrand(brands);
            products.setProductAttachmentList(attachmentList);
            productRepository.save(products);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<ResponseProductDTO> getAllProduct() {

        return productRepository.findAll().stream().map(responseProductDTOMapper).toList();
    }

    @Override
    public ResponseProductDTO productSearch(String name) throws ApiMessage {
        final Products products = searchProductName(name);

        if ( products == null){
            throw new ApiMessage("No search product!");
        }
//        List<ResponseAttachmentDTO> attachmentDTOList = new ArrayList<>();
//        final List<Attachment> productAttachmentList = products.getProductAttachmentList();
//
//        for (Attachment a: productAttachmentList){
//            attachmentDTOList.add(responseAttachmentDTOMapper.apply(a));
//        }

        return responseProductDTOMapper.apply(products);
    }

    @Override
    public void productDelete(String name) throws ApiMessage {
        final Products products = searchProductName(name);
        if ( products == null){
            throw new ApiMessage("No search product!");
        }
        productRepository.deleteById(products.getId());
    }

    private Products searchProductName(String name){
        return productRepository.findByProductName(name).orElse(null);
    }

    @Override
    public List<ResponseProductDTO> getSearchSlugProduct(String slug) {
        final Optional<List<Products>> allBySlug = productRepository.findAllBySlug(slug);

        return getAllProduct(allBySlug);
    }

    @Override
    public List<ResponseProductDTO> getSearchBrandProduct(String brandName) {
        final Brands brands = brandSearchService.getBrandsID(brandName);
        if (brands == null){
            return null;
        }
        final Optional<List<Products>> allByBrand = productRepository.findAllByBrand(brands);

        return getAllProduct(allByBrand);
    }

    private List<ResponseProductDTO> getAllProduct(Optional<List<Products>> products){
        if (products.isEmpty()){
            return null;
        }
        List<ResponseProductDTO> dtoList = new ArrayList<>();
        for (Products p : products.get()){
            dtoList.add(responseProductDTOMapper.apply(p));
        }
        return dtoList;
    }
}
