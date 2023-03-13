package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Options;
import com.attrabit.ecom.repository.OptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionsService {

    @Autowired
    private OptionsRepository optionsRepository;

    public List<Options> getAllOptions() {
        return optionsRepository.findAll();
    }

    public Optional<Options> getOptionsById(Long id) {
        return optionsRepository.findById(id);
    }

    public Options createOptions(Options options) {
        return optionsRepository.save(options);
    }

    public Options updateOptions(Long id, Options options) {
        options.setId(id);
        return optionsRepository.save(options);
    }

    public void deleteOptions(Long id) {
        optionsRepository.deleteById(id);
    }
}
