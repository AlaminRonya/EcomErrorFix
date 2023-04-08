package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.response.ResponseTaxClassesDTO;
import com.attrabit.ecom.dto.response.ResponseAttachmentDTO;
import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.model.TaxClasses;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResponseTaxClassesDTOMapper implements Function<TaxClasses, ResponseTaxClassesDTO> {
    @Override
    public ResponseTaxClassesDTO apply(TaxClasses taxClasses) {
        return (taxClasses != null) ? new ResponseTaxClassesDTO(
                taxClasses.getId(), taxClasses.getBasedOn(), taxClasses.getDeletedAt(),
                taxClasses.getCreatedAt(), taxClasses.getUpdatedAt()
        ) : null;
    }
}
