package com.swiftCart.catalogo_service.dto.request;

import com.swiftCart.catalogo_service.models.SubCategoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequest {

    private String nombre;
    private String descripcion;
    private Integer idEmpresa;
    private Integer idSubCategoria;
    private MultipartFile multipartFile;
}
