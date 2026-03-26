package com.swiftCart.catalogo_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoriaRequest {

    private String nombre;
    private Integer idCategoria;
}
