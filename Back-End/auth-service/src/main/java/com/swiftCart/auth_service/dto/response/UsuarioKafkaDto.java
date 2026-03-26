package com.swiftCart.auth_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioKafkaDto {

    private Integer id;
    private String nombres;
    private String apellido;
    private String correo;
}
