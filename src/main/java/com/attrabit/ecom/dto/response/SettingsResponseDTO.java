package com.attrabit.ecom.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SettingsResponseDTO {
    private Long id;
    private LocalDateTime createdAt;
    private boolean isTranslatable;
    private String key;
    private String plainValue;
    private LocalDateTime updatedAt;
}
