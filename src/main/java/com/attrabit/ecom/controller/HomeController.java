package com.attrabit.ecom.controller;


import com.attrabit.ecom.constant.URLSuppliers;
import com.attrabit.ecom.dto.respose.ResponseUserDTO;
import com.attrabit.ecom.repository.RolesRepository;
import com.attrabit.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    private final UserService userService;
    private final RolesRepository rolesRepository;

    @GetMapping(URLSuppliers.HOME_PAGE_URLS)
    public ResponseEntity<String> home(){

        rolesRepository.findAll().forEach(System.out::println);
        return new ResponseEntity<>("Home Page", HttpStatus.OK);
    }


    @GetMapping(URLSuppliers.HOME_PAGE_ALL_USERS_URLS)
    public ResponseEntity<List<ResponseUserDTO>> all(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }


}
