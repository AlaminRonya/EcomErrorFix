package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import org.springframework.web.multipart.MultipartFile;

public interface UsersService {
    void usersInfo(String userEmail, MultipartFile image, RequestAddressDTO dto);
}
