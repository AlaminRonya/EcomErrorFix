package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class ComparedAddressDTOMapper implements BiFunction<Addresses, Addresses, Addresses> {
    @Override
    public Addresses apply(Addresses addresses, Addresses dto) {
        if (addresses.getFirstName().isEmpty() || !addresses.getFirstName().equals(dto.getFirstName())){
            addresses.setFirstName(dto.getFirstName());
        }
        if (addresses.getLastName().isEmpty() || !addresses.getLastName().equals(dto.getLastName())){
            addresses.setLastName(dto.getLastName());
        }
        if (addresses.getAddress1().isEmpty() || !addresses.getAddress1().equals(dto.getAddress1())){
           addresses.setAddress1(dto.getAddress1());
        }
        if (addresses.getAddress2().isEmpty() || !addresses.getAddress2().equals(dto.getAddress2())){
            addresses.setAddress2(dto.getAddress2());
        }
        if (addresses.getCity().isEmpty() || !addresses.getCity().equals(dto.getCity())) {
            addresses.setCity(dto.getCity());
        }
        if (addresses.getState().isEmpty() || !addresses.getState().equals(dto.getState())){
            addresses.setState(dto.getState());
        }

        if (addresses.getZip().isEmpty() || !addresses.getZip().equals(dto.getZip())){
            addresses.setZip(dto.getZip());
        }
        if (addresses.getCountry().isEmpty() || !addresses.getCountry().equals(dto.getCountry())){
            addresses.setCountry(dto.getCountry());
        }
        return addresses;
    }
}
