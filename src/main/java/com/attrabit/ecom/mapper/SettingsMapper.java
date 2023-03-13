package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.response.SettingsResponseDTO;
import com.attrabit.ecom.dto.request.SettingsRequestDTO;
import com.attrabit.ecom.model.Settings;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SettingsMapper {
    SettingsMapper INSTANCE = Mappers.getMapper(SettingsMapper.class);

    Settings fromRequestDTO(SettingsRequestDTO request);

    SettingsResponseDTO toDTO(Settings entity);
}

