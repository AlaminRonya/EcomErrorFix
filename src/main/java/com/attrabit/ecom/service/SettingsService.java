package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.SettingsRequestDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Settings;
import com.attrabit.ecom.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SettingsService {

    private final SettingsRepository settingsRepository;

    @Autowired
    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public void createSettings(SettingsRequestDTO request) throws ApiMessage {
        try {
            Settings settings = new Settings();
            settings.setCreatedAt(LocalDateTime.now());
            settings.setUpdatedAt(LocalDateTime.now());
            settings.setIsTranslatable(request.getIsTranslatable());
            settings.setKey(request.getKey());
            settings.setPlainValue(request.getPlainValue());
            settingsRepository.save(settings);
        } catch(Exception e){
            throw new ApiMessage("Internal Error: "+e.getMessage());
        }
    }

    public Settings getSettingsById(Long id) {
        return settingsRepository.findById(id).orElse(null);
    }

    public Settings updateSettings(Long id, SettingsRequestDTO request) {
        return settingsRepository.findById(id)
                .map(settings -> {
                    settings.setUpdatedAt(LocalDateTime.now());
                    settings.setIsTranslatable(request.getIsTranslatable());
                    settings.setKey(request.getKey());
                    settings.setPlainValue(request.getPlainValue());
                    return settingsRepository.save(settings);
                })
                .orElse(null);
    }

    public void deleteSettingsById(Long id) {
        settingsRepository.deleteById(id);
    }

    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }
}
