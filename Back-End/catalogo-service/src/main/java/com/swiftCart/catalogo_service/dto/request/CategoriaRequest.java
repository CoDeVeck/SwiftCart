package com.swiftCart.catalogo_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest {
    private String descripcion;
    private MultipartFile multipartFile;
}
