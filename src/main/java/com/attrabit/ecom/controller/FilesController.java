package com.attrabit.ecom.controller;

import com.attrabit.ecom.model.Files;
import com.attrabit.ecom.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FilesController {

    @Autowired
    private FilesService filesService;

    @GetMapping
    public List<Files> findAll() {
        return filesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Files> findById(@PathVariable Long id) {
        Optional<Files> optionalFiles = filesService.findById(id);
        if (optionalFiles.isPresent()) {
            return ResponseEntity.ok(optionalFiles.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Files save(@RequestBody Files files) {
        return filesService.save(files);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Files> update(@PathVariable Long id, @RequestBody Files files) {
        Optional<Files> optionalFiles = filesService.findById(id);
        if (optionalFiles.isPresent()) {
            files.setId(id);
            return ResponseEntity.ok(filesService.save(files));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        filesService.deleteById(id);
    }
}
