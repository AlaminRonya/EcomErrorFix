package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.model.Users;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UsersService {
    void usersInfo(String userEmail, MultipartFile image, RequestAddressDTO dto);

    void getUsers(String email);
}
