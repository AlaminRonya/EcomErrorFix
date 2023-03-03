package com.attrabit.ecom.service;

import com.attrabit.ecom.model.Activations;
import com.attrabit.ecom.repository.ActivationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivationsService {
    @Autowired
    private ActivationsRepository activationsRepository;

    public List<Activations> getAllActivations() {
        return activationsRepository.findAll();
    }

    public Optional<Activations> getActivationById(Long id) {
        return activationsRepository.findById(id);
    }

    public Activations createActivation(Activations activation) {
        return activationsRepository.save(activation);
    }

    public Activations updateActivation(Long id, Activations activation) {
        Optional<Activations> optionalActivation = activationsRepository.findById(id);
        if (optionalActivation.isPresent()) {
            activation.setId(id);
            return activationsRepository.save(activation);
        } else {
            return null;
        }
    }

    public void deleteActivation(Long id) {
        activationsRepository.deleteById(id);
    }
}
