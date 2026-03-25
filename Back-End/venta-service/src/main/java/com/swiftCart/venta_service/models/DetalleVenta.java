package com.swiftCart.venta_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DETALLE_VENTA")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_DETALLE_VENTA")
    private Integer idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "ID_VENTA")
    private Venta venta;

    @Column(name="ID_PRODUCTO_SUCURSAL")
    private Integer idProductoSucursal;

    @Column(name="CANTIDAD")
    private  Integer cantidad;

    @Column(name="PRECIO_UNITARIO")
    private BigDecimal precioUnitario;

    @Column(name="SUB_TOTAL")
    private BigDecimal subTotal;


}
