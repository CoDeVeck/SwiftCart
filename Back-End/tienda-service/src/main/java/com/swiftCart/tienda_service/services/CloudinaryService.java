package com.swiftCart.tienda_service.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public Map<String,String> upload(MultipartFile multipartFile, String carpeta) throws IOException {

        Map upload = cloudinary.uploader().upload(multipartFile.getBytes(),
                ObjectUtils.asMap("folder",carpeta));

        String url = upload.get("secure_url").toString();
        String publicId = upload.get("public_id").toString();

        Map<String,String> response = new HashMap<>();

        response.put("url",url);
        response.put("public_id",publicId);

        return response;
    }

    public void eliminar(String publicId) throws IOException{
        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}
