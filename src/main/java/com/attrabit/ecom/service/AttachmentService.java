package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.respose.ResponseAttachmentDTO;
import com.attrabit.ecom.model.Attachment;

public interface AttachmentService {
    Attachment addAttachment(String userEmail, Attachment attachment);
    ResponseAttachmentDTO getAttachmentByUserEmail(String email);
}
