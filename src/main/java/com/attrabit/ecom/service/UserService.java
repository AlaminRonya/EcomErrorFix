package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.respose.ResponseUserDTO;

import java.util.List;


public interface UserService {
    List<ResponseUserDTO> getAllUser();
}

