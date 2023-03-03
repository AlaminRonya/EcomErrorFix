package com.attrabit.ecom.service;

import com.attrabit.ecom.model.AttributeValues;
import com.attrabit.ecom.repository.AttributeValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeValuesService {

    private final AttributeValuesRepository attributeValuesRepository;

    @Autowired
    public AttributeValuesService(AttributeValuesRepository attributeValuesRepository) {
        this.attributeValuesRepository = attributeValuesRepository;
    }

    public List<AttributeValues> getAllAttributeValues() {
        return attributeValuesRepository.findAll();
    }

    public Optional<AttributeValues> getAttributeValuesById(Long id) {
        return attributeValuesRepository.findById(id);
    }

    public AttributeValues saveAttributeValues(AttributeValues attributeValues) {
        return attributeValuesRepository.save(attributeValues);
    }

    public void deleteAttributeValuesById(Long id) {
        attributeValuesRepository.deleteById(id);
    }
}
