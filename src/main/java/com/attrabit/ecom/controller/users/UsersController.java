package com.attrabit.ecom.controller.users;

import com.attrabit.ecom.constant.URLSuppliers;
import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.request.TestDTO;
import com.attrabit.ecom.dto.respose.Response;
import com.attrabit.ecom.dto.respose.ResponseUserDTO;
import com.attrabit.ecom.dto.respose.ResponseUserInfoDTO;
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

import java.util.Map;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.data.jpa.util.JpaMetamodel.of;
import static org.springframework.http.HttpStatus.OK;

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

        return new ResponseEntity<>("User Info", OK);
    }
    @GetMapping("/api/v1/auth/users/{email}")
    public ResponseEntity<Response> getUserByEmail(@PathVariable("email") String email){
        var users = usersService.getUsers(email);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("userInfo",users))
                        .message("Success")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
//        return new ResponseEntity<>(usersService.getUsers(email), OK);
    }


}
