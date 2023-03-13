package com.attrabit.ecom.mapper;

import com.attrabit.ecom.dto.response.ResponseUserDTO;
import com.attrabit.ecom.model.Users;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ResponseUserDTOMapper implements Function<Users, ResponseUserDTO> {
    @Override
    public ResponseUserDTO apply(Users user) {
        return new ResponseUserDTO(
                user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPhone(), user.getPassword(), user.getPermissions(), user.getLastLogin(),
                user.getCreatedAt(), user.getUpdatedAt()
        );
    }
}
