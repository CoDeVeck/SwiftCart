package com.swiftCart.catalogo_service.feign.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioFeign {

    private UUID uuid;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String correo;
    private String tipoDoc;
    private String nroDoc;
    private String direccion;
    private String nombreDistrito;
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String telefono;
    private String imagen;
}
