package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.respose.ResponseUserDTO;
import com.attrabit.ecom.mapper.ResponseUserDTOMapper;
import com.attrabit.ecom.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UsersRepository userRepository;
    private final ResponseUserDTOMapper responseUserDTOMapper;
    @Override
    public List<ResponseUserDTO> getAllUser() {
        return userRepository.findAll().stream().map(responseUserDTOMapper).toList();
    }



}
