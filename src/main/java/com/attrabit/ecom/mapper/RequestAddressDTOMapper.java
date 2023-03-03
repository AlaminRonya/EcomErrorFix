package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RequestAddressDTOMapper implements Function<RequestAddressDTO, Addresses> {

    @Override
    public Addresses apply(RequestAddressDTO dto) {

        Addresses addresses = new Addresses();
        addresses.setFirstName(dto.firstName());
        addresses.setLastName(dto.lastName());
        addresses.setAddress1(dto.address1());
        addresses.setAddress2(dto.address2());
        addresses.setCity(dto.city());
        addresses.setState(dto.state());
        addresses.setZip(dto.zip());
        addresses.setCountry(dto.country());
        addresses.setCreatedAt(DateUtils.getDate());

        return addresses;
    }
}
