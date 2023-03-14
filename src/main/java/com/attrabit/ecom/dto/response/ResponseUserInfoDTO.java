package com.attrabit.ecom.dto.response;

import com.attrabit.ecom.dto.respose.ResponseAddressDTO;
import com.attrabit.ecom.dto.respose.ResponseAttachmentDTO;

public record ResponseUserInfoDTO(ResponseUserDTO userDTO, ResponseAddressDTO addressDTO, ResponseAttachmentDTO attachmentDTO) {

}
