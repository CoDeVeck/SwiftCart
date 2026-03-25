package com.swiftCart.auth_service.dto.request;

import com.swiftCart.auth_service.enums.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarUsuarioRequest {

    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String correo;
    private String clave;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDoc;
    private String nroDoc;
    private String direccion;
    private Integer idDistrito;
    private String telefono;
    private Integer idCargo;
}
