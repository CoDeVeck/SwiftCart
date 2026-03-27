package com.swiftCart.tienda_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SucursalRequest {

    private String nombreUbicacion;
    private Integer idEmpresa;
    private Integer idDistrito;
    private String direccion;
    private LocalDate fechaApertura;
    private MultipartFile multipartFile;
}
