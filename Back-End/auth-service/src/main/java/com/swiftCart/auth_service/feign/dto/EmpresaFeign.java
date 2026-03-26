package com.swiftCart.auth_service.feign.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaFeign {

    private Integer idEmpresa;
    private String ruc;
    private String razoSocial;
    private String imagen;
    private String publicId;
    private String telefono;
    private String direccion;
    private Integer idDistrito;
    private LocalDateTime fechaRegistro;
    private boolean estado;


}
