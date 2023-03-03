package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.mapper.ComparedAddressDTOMapper;
import com.attrabit.ecom.mapper.RequestAddressDTOMapper;
import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.repository.AddressRepository;
import com.attrabit.ecom.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService{
    private final RequestAddressDTOMapper requestAddressDTOMapper;
    private final AddressRepository addressRepository;
    private final UsersRepository usersRepository;
    private final ComparedAddressDTOMapper comparedAddressDTOMapper;

    @Override
    public Addresses addUserAddress(String userEmail, RequestAddressDTO dto) {
        final Addresses addresses = requestAddressDTOMapper.apply(dto);
        final Optional<Users> byEmail = usersRepository.findByEmail(userEmail);
        if (byEmail.isEmpty()){
            return null;
        }
        final Optional<Addresses> byCustomers = addressRepository.findByCustomers(byEmail.get());
        if (byCustomers.isPresent()){
            // TODO: 3/3/2023 Address Update write code
            final Addresses apply = comparedAddressDTOMapper.apply(byCustomers.get(), addresses);
            System.out.println(apply);

            return byCustomers.get();
        }
        addresses.setCustomers(byEmail.get());
        return addressRepository.save(addresses);
    }
}
