package com.swiftCart.catalogo_service.models;

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
@Table(name = "TB_PRODUCTO")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ID_EMPRESA")
    private Integer idEmpresa;

    @ManyToOne
    @JoinColumn(name = "ID_SUBCATEGORIA")
    private SubCategoria subCategoria;

    @Column(name = "IMAGEN")
    private String imagen;

    @Column(name = "PUBLIC_ID")
    private String publicId;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegristro;

    @Column(name = "ESTADO")
    private boolean estado;

}
