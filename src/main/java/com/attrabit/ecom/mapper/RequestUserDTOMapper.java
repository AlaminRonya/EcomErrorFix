package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.function.Function;
@Service
public class RequestUserDTOMapper implements Function<RequestUserDTO, Users> {
    @Override
    public Users apply(RequestUserDTO dto) {
        Users user = new Users();
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setPhone(dto.phone());
        user.setCreatedAt(DateUtils.getDate());
        return user;
    }
}
