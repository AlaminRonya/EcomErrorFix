package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.response.ResponseAddressDTO;
import com.attrabit.ecom.model.Addresses;


public interface AddressService {
    Addresses addUserAddress(String userEmail, RequestAddressDTO dto);
    ResponseAddressDTO getAddressUsers(String email);

}
