package com.swiftCart.tienda_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_SUCURSAL")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUCURSAL")
    private Integer idSucursal;

    @Column(name = "NOMBRE_UBICACION")
    private String nombreUbicacion;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "ID_DISTRITO")
    private Integer idDistrito;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "FECHA_APERTURA")
    private LocalDate fechaApertura;
}
