package com.attrabit.ecom.service;

import com.attrabit.ecom.model.AttributeSets;
import com.attrabit.ecom.repository.AttributeSetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeSetsService {

    private final AttributeSetsRepository attributeSetsRepository;

    @Autowired
    public AttributeSetsService(AttributeSetsRepository attributeSetsRepository) {
        this.attributeSetsRepository = attributeSetsRepository;
    }

    public List<AttributeSets> getAllAttributeSets() {
        return attributeSetsRepository.findAll();
    }

    public Optional<AttributeSets> getAttributeSetById(Long id) {
        return attributeSetsRepository.findById(id);
    }

    public AttributeSets saveAttributeSet(AttributeSets attributeSet) {
        return attributeSetsRepository.save(attributeSet);
    }

    public void deleteAttributeSetById(Long id) {
        attributeSetsRepository.deleteById(id);
    }
}
