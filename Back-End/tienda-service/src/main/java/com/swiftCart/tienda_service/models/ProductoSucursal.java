package com.swiftCart.tienda_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PRODUCTO_SUCURSAL")
public class ProductoSucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO_SUCURSAL")
    private Integer idProductoSucursal;

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    @ManyToOne
    @JoinColumn(name = "ID_SUCURSAL")
    private Sucursal sucursal;

    @Column(name = "MIN_STOCK")
    private Integer minStock;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "MAX_STOCK")
    private Integer maxStock;

    @Column(name = "PRECIO")
    private BigDecimal precio;

    @Column(name = "ESTADO")
    private boolean estado;

}
