package com.swiftCart.tienda_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalResponse {

    private String nombreUbicacion;
    private String nombreEmpresa;
    private String imagen;
    private String nombreDistrito;
    private String direccion;
    private String fechaApertura;

}
