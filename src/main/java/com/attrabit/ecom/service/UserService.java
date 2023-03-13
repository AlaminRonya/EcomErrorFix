package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.response.ResponseUserDTO;

import java.util.List;


public interface UserService {
    List<ResponseUserDTO> getAllUser();
}

