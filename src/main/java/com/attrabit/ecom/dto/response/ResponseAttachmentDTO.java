package com.attrabit.ecom.dto.response;

import jakarta.persistence.Column;

import java.util.Date;

public record ResponseAttachmentDTO(
        Long id,String userEmail,String filename,String disk,String path,String extension,
        String mime,String size,Date createdAt, Date updatedAt
) {

}
