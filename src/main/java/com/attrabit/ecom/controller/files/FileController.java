package com.attrabit.ecom.controller.files;

import com.attrabit.ecom.dto.request.TestDTO;
import com.attrabit.ecom.files.FileService;
import com.attrabit.ecom.utils.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/file")
public class FileController {
    private final FileService fileService;
    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file, @RequestParam("dto") String dto) throws IOException {
        System.out.println("====>"+dto);

        if (file.isEmpty()){
            System.out.println("=====================");
        }

        ObjectMapper mapper = new ObjectMapper();
        TestDTO testDTO = mapper.readValue(dto, TestDTO.class);
        System.out.printf("---------"+testDTO);


        fileService.uploadImage(Constant.IMAGE_PATH, file);



        return null;
    }
}
