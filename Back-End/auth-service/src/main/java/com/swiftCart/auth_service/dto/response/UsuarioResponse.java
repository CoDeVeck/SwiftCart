package com.swiftCart.auth_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private UUID uuid;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String distrito;
}
