package com.attrabit.ecom.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class SettingsRequestDTO {
    @NotBlank
    private String key;
    private Boolean isTranslatable;
    private String plainValue;
}

