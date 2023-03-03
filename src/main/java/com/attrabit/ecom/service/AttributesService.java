package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Attributes;
import com.attrabit.ecom.repository.AttributesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributesService {

    @Autowired
    private AttributesRepository attributesRepository;

    public List<Attributes> getAllAttributes() {
        return attributesRepository.findAll();
    }

    public Optional<Attributes> getAttributeById(Long id) {
        return attributesRepository.findById(id);
    }

    public Attributes createAttribute(Attributes attribute) {
        return attributesRepository.save(attribute);
    }

    public Attributes updateAttribute(Long id, Attributes attribute) {
        Optional<Attributes> optionalAttribute = attributesRepository.findById(id);
        if (optionalAttribute.isPresent()) {
            attribute.setId(id);
            return attributesRepository.save(attribute);
        }
        return null;
    }

    public void deleteAttribute(Long id) {
        attributesRepository.deleteById(id);
    }
}
