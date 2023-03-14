package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.respose.ResponseAddressDTO;
import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Users;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResponseAddressDTOMapper implements Function<Addresses, ResponseAddressDTO> {
    @Override
    public ResponseAddressDTO apply(Addresses addresses) {
        return (addresses != null) ? new ResponseAddressDTO(
                addresses.getId(), addresses.getFirstName(), addresses.getLastName(), addresses.getAddress1(),
                addresses.getAddress2(), addresses.getCity(), addresses.getState(),
                addresses.getZip(), addresses.getCountry(), addresses.getCreatedAt(),
                addresses.getUpdatedAt()
        ): null;
    }
}
