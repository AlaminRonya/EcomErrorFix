package com.attrabit.ecom.controller;

import com.attrabit.ecom.constant.URLSuppliers;
import com.attrabit.ecom.dto.request.AuthenticationRequest;
import com.attrabit.ecom.dto.request.RequestUserDTO;
import com.attrabit.ecom.dto.respose.AuthenticationResponse;
import com.attrabit.ecom.exception.ApiMessage;
import com.attrabit.ecom.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(URLSuppliers.HOME_CONTROLLER_URLS)
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping(URLSuppliers.USER_SIGNUP)
    public ResponseEntity<AuthenticationResponse> addUser(@Valid @RequestBody RequestUserDTO dto) throws ApiMessage {
//        System.out.println(dto);
//        User user = new User();
//        user.setFirstName(dto.firstName());
//        user.setLastName(dto.lastName());
//        user.setEmail(dto.email());
//        user.setPhone(dto.phone());
//        user.setPassword(dto.password());
//        if (Objects.equals(dto.phone(), "")) {
//            System.out.println("==================>");
//        }
        final AuthenticationResponse authenticationResponse = registrationService.addUser(dto);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @PostMapping(URLSuppliers.USER_LOGIN)
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
//        return ResponseEntity.ok(registrationService.authenticate(request));
        return new ResponseEntity<>(registrationService.authenticate(request), HttpStatus.OK);
    }
}
