package com.attrabit.ecom.dto.response;

import com.attrabit.ecom.dto.response.ResponseAddressDTO;
import com.attrabit.ecom.dto.response.ResponseAttachmentDTO;

public record ResponseUserInfoDTO(ResponseUserDTO userDTO, ResponseAddressDTO addressDTO, ResponseAttachmentDTO attachmentDTO) {

}
