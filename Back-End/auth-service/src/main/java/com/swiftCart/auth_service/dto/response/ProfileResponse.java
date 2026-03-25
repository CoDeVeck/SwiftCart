package com.swiftCart.auth_service.dto.response;

import com.swiftCart.auth_service.enums.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {

    private UUID uuid;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String correo;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_DOC")
    private TipoDocumento tipoDoc;
    private String nroDoc;
    private String direccion;
    private String nombreDistrito;
    private String telefono;
    private String imagen;

}
