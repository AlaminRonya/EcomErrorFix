package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.response.ResponseAttachmentDTO;
import com.attrabit.ecom.model.Attachment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResponseAttachmentDTOMapper implements Function<Attachment, ResponseAttachmentDTO> {
    @Override
    public ResponseAttachmentDTO apply(Attachment attachment) {
        return (attachment != null) ? new ResponseAttachmentDTO(
                attachment.getId(), attachment.getUserEmail(), attachment.getFilename(), attachment.getDisk(),
                attachment.getPath(), attachment.getExtension(), attachment.getMime(), attachment.getSize(),
                attachment.getCreatedAt(), attachment.getCreatedAt()
        ):null;
    }

}
