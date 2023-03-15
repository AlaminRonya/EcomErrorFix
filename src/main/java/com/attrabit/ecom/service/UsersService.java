package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.response.ResponseUserInfoDTO;
import com.attrabit.ecom.dto.response.ResponseAddressDTO;

import com.attrabit.ecom.model.Users;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface UsersService {
    void usersInfo(String userEmail, MultipartFile image, RequestAddressDTO dto);

    ResponseUserInfoDTO getUsers(String email);
}
