package com.attrabit.ecom.files;

import com.attrabit.ecom.model.Attachment;
import com.attrabit.ecom.repository.FileRepository;
import com.attrabit.ecom.utils.Constant;
import com.attrabit.ecom.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService{
    private final FileRepository fileRepository;
    @Override
    public Attachment uploadImage(String path, MultipartFile file) throws IOException {
        final String originalFilename = file.getOriginalFilename();
        final String contentType = file.getContentType();



        //File name
        String name = file.getOriginalFilename();


        //Random file name generate
        String randomId = UUID.randomUUID().toString();

        String fileName1 = randomId.concat(name.substring(name.lastIndexOf(".")));


        //Full path
//        String filePath = path+ File.separator+name;
        String filePath = Constant.IMAGE_PATH + File.separator+fileName1;

        //create folder if not created
        File f = new File(Constant.IMAGE_PATH);
        if (!f.exists()){
            f.mkdir();
        }

        //File copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

//        Attachment attachment = new Attachment();
//        attachment.setFilename(originalFilename);
//        attachment.setExtension(contentType);
//        attachment.setPath(filePath);
//        attachment.setDisk(fileName1);
//        attachment.setCreatedAt(DateUtils.getDate());

        return null;
    }
}
