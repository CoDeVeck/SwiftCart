package com.swiftCart.tienda_service.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistritoFeign {

    private Integer idDistrito;
    private String nombre;
}
