package com.ecommerce.ECommerceBackend.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadedImage(String path, MultipartFile image) throws IOException;
}
