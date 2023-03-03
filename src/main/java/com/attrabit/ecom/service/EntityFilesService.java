// EntityFilesService.java
package com.attrabit.ecom.service;

import com.attrabit.ecom.model.EntityFiles;
import com.attrabit.ecom.repository.EntityFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityFilesService {

    private EntityFilesRepository entityFilesRepository;

    @Autowired
    public EntityFilesService(EntityFilesRepository entityFilesRepository) {
        this.entityFilesRepository = entityFilesRepository;
    }

    public List<EntityFiles> getAllEntityFiles() {
        return entityFilesRepository.findAll();
    }

    public Optional<EntityFiles> getEntityFilesById(Long id) {
        return entityFilesRepository.findById(id);
    }

    public EntityFiles saveEntityFiles(EntityFiles entityFiles) {
        return entityFilesRepository.save(entityFiles);
    }

    public void deleteEntityFiles(Long id) {
        entityFilesRepository.deleteById(id);
    }
}
