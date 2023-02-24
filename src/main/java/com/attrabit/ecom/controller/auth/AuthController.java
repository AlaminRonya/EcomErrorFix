package com.attrabit.ecom.controller.auth;

import com.attrabit.ecom.constant.URLSuppliers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    @GetMapping(URLSuppliers.USER_DASHBOARD)
//    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public ResponseEntity<String> home(){

        return new ResponseEntity<>("User dashboard Page", HttpStatus.OK);
    }
}
