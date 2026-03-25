package com.swiftCart.tienda_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;

    @Column(name = "RUC")
    private String ruc;

    @Column(name = "RAZON_SOCIAL")
    private String razoSocial;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @Column(name = "ESTADO")
    private boolean estado;

}
