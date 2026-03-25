package com.swiftCart.auth_service.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swiftCart.auth_service.enums.TipoDocumento;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProfileRequest {

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
    private Integer idDistrito;
    private String telefono;
    private String imagen;

    @JsonIgnore
    @Transient
    private MultipartFile imagenMultipart;
}
