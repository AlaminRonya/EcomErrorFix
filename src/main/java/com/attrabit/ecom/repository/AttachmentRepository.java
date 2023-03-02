package com.attrabit.ecom.repository;

import com.attrabit.ecom.model.Attachment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Optional<Attachment> findByUserEmail(String userEmail);
}
