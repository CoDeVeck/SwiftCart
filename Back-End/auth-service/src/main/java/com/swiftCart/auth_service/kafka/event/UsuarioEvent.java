package com.swiftCart.auth_service.kafka.event;

import com.swiftCart.auth_service.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEvent {
    private String mensaje;
    private String status;
    private Usuario usuario;
}
