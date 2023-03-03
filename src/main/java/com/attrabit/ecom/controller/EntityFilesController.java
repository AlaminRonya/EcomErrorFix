// EntityFilesController.java
package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.EntityFiles;
import com.attrabit.ecom.service.EntityFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entity-files")
public class EntityFilesController {

    private EntityFilesService entityFilesService;

    @Autowired
    public EntityFilesController(EntityFilesService entityFilesService) {
        this.entityFilesService = entityFilesService;
    }

    @GetMapping("")
    public ResponseEntity<List<EntityFiles>> getAllEntityFiles() {
        List<EntityFiles> entityFilesList = entityFilesService.getAllEntityFiles();
        return new ResponseEntity<>(entityFilesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityFiles> getEntityFilesById(@PathVariable Long id) {
        Optional<EntityFiles> entityFilesOptional = entityFilesService.getEntityFilesById(id);
        if (entityFilesOptional.isPresent()) {
            EntityFiles entityFiles = entityFilesOptional.get();
            return new ResponseEntity<>(entityFiles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<EntityFiles> saveEntityFiles(@RequestBody EntityFiles entityFiles) {
        EntityFiles savedEntityFiles = entityFilesService.saveEntityFiles(entityFiles);
        return new ResponseEntity<>(savedEntityFiles, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntityFiles(@PathVariable Long id) {
        entityFilesService.deleteEntityFiles(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
