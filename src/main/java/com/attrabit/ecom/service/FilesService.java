package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Files;
import com.attrabit.ecom.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilesService {

    @Autowired
    private FilesRepository filesRepository;

    public List<Files> findAll() {
        return filesRepository.findAll();
    }

    public Optional<Files> findById(Long id) {
        return filesRepository.findById(id);
    }

    public Files save(Files files) {
        return filesRepository.save(files);
    }

    public void deleteById(Long id) {
        filesRepository.deleteById(id);
    }
}
