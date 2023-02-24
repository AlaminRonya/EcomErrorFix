package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.AuthenticationRequest;
import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.dto.respose.AuthenticationResponse;
import com.attrabit.ecom.exception.ApiMessage;


public interface RegistrationService {
    AuthenticationResponse addUser(RequestUserDTO dto) throws ApiMessage;
    AuthenticationResponse authenticate(AuthenticationRequest request);

}
