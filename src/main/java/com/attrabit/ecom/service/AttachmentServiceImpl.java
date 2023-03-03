package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.repository.AttachmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AttachmentServiceImpl implements AttachmentService{
    private final AttachmentRepository attachmentRepository;
    @Override
    public Attachment addAttachment(String userEmail, Attachment attachment) {
        final Optional<Attachment> byUserEmail = attachmentRepository.findByUserEmail(userEmail);
        if (byUserEmail.isPresent()){
            return byUserEmail.get();
        }

        attachment.setUserEmail(userEmail);
        return attachmentRepository.save(attachment);
    }
}
