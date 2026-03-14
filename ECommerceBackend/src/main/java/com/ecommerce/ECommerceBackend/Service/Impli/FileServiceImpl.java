package com.ecommerce.ECommerceBackend.Service.Impli;

import com.ecommerce.ECommerceBackend.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadedImage(String path, MultipartFile image) throws IOException {
            //File names of Current/Original File
            String originalName = image.getOriginalFilename();
            //Generate a Unique file name
            String randomId = UUID.randomUUID().toString();
            //mat.jpg randomId = 1234 -> 1234.jpg
            String fileName = randomId.concat(originalName.substring(originalName.lastIndexOf(".")));
            String filePath = path + File.separator + fileName;
            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdir();
            }
            //Upload to Server
            Files.copy(image.getInputStream(), Paths.get(filePath));
            return fileName;
    }
}
