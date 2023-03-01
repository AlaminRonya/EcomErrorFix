package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.model.Addresses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface AddressService {
    void addAddress(RequestAddressDTO dto);
}
