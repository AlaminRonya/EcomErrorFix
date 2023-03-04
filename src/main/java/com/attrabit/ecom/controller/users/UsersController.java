package com.attrabit.ecom.controller.users;

import com.attrabit.ecom.constant.URLSuppliers;
import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.request.TestDTO;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.repository.RolesRepository;
import com.attrabit.ecom.repository.UsersRepository;
import com.attrabit.ecom.service.UsersService;
import com.attrabit.ecom.utils.DateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    private final RolesRepository rolesRepository;
    @PostMapping(URLSuppliers.USER_INFO)
    public ResponseEntity<String> infoAdd(@RequestParam("email") String userEmail, @RequestParam("image") MultipartFile file, @RequestParam("dto") String dto) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            final RequestAddressDTO requestAddressDTO = mapper.readValue(dto, RequestAddressDTO.class);
            System.out.println(requestAddressDTO);
            usersService.usersInfo(userEmail, file, requestAddressDTO);
        }catch (Exception e){
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("User Info", HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<String> getUserByEmail(@PathVariable("email") String email){
        return new ResponseEntity<>("Users info", HttpStatus.OK);
    }
}
