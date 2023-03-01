package com.attrabit.ecom.files;

import com.attrabit.ecom.model.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    Attachment uploadImage(String path, MultipartFile file) throws IOException;
}
