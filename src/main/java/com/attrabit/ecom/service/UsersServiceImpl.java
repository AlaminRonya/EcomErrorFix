package com.attrabit.ecom.service;

import com.attrabit.ecom.dto.request.RequestAddressDTO;
import com.attrabit.ecom.dto.response.ResponseUserInfoDTO;
import com.attrabit.ecom.dto.response.ResponseAddressDTO;

import com.attrabit.ecom.files.FileService;
import com.attrabit.ecom.mapper.ResponseUserDTOMapper;
import com.attrabit.ecom.model.Addresses;
import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.model.Users;
import com.attrabit.ecom.repository.UsersRepository;
import com.attrabit.ecom.utils.Constant;
import com.attrabit.ecom.utils.DateUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;
    private final AddressService addressService;
    private final FileService fileService;
    private final AttachmentService attachmentService;
    private final ResponseUserDTOMapper responseUserDTOMapper;

    @Override
    public void usersInfo(String userEmail, MultipartFile image, RequestAddressDTO dto) {
        try {
            System.out.println("-------------------------------------");

            System.out.println(userEmail);
            final Optional<Users> byEmail = usersRepository.findByEmail(userEmail);

            if (byEmail.isEmpty()){
                return;
            }
            final Users users = byEmail.get();

            final Attachment attachment = fileService.uploadImage(Constant.IMAGE_PATH, image);
            final Addresses addresses = addressService.addUserAddress(userEmail, dto);
            final Attachment attachment1 = attachmentService.addAttachment(userEmail, attachment);

//            usersRepository.updatedUsersInfoById(users.getId(), attachment1, addresses);



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResponseUserInfoDTO getUsers(String email) {
        final Users users = usersRepository.findByEmail(email).orElse(null);
        if (users == null){
            return null;
        }
        var addressUsers = addressService.getAddressUsers(email);
        var attachment = attachmentService.getAttachmentByUserEmail(email);
        var apply = responseUserDTOMapper.apply(users);

        return new ResponseUserInfoDTO(apply, addressUsers, attachment);

    }


}
