package com.attrabit.ecom.dto.respose;

import lombok.Data;

public record ResponseUserInfoDTO(ResponseUserDTO userDTO, ResponseAddressDTO addressDTO, ResponseAttachmentDTO attachmentDTO) {

}
