package com.attrabit.ecom.controller;


import com.attrabit.ecom.dto.response.SettingsResponseDTO;
import com.attrabit.ecom.dto.request.SettingsRequestDTO;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.model.Settings;
import com.attrabit.ecom.service.SettingsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsService settingsService;

    @Autowired
    public SettingsController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PostMapping("")
    public ResponseEntity<String> createSettings(@RequestBody SettingsRequestDTO request) throws ApiMessage {
        settingsService.createSettings(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Your Data Has Been Stored");
    }

    @GetMapping("/{id}")
    public ResponseEntity<SettingsResponseDTO> getSettingsById(@PathVariable Long id) {
        Settings settings = settingsService.getSettingsById(id);
        if (settings != null) {
            return ResponseEntity.ok().body(convertToDto(settings));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<SettingsResponseDTO> updateSettings(@PathVariable Long id, @RequestBody SettingsRequestDTO request) {
        Settings settings = settingsService.updateSettings(id, request);
        if (settings != null) {
            return ResponseEntity.ok().body(convertToDto(settings));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSettingsById(@PathVariable Long id) {
        settingsService.deleteSettingsById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("")
    public ResponseEntity<List<SettingsResponseDTO>> getAllSettings() {
        List<Settings> settingsList = settingsService.getAllSettings();
        if (!settingsList.isEmpty()) {
            List<SettingsResponseDTO> dtoList = settingsList.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(dtoList);
        }
        return ResponseEntity.noContent().build();
    }

    private SettingsResponseDTO convertToDto(Settings settings) {
        SettingsResponseDTO dto = new SettingsResponseDTO();
        BeanUtils.copyProperties(settings, dto);
        return dto;
    }
}


