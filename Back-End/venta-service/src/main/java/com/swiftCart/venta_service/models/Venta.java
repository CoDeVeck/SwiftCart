package com.swiftCart.venta_service.models;

import com.swiftCart.venta_service.enums.EstadoVenta;
import com.swiftCart.venta_service.enums.MetodoEntrega;
import com.swiftCart.venta_service.enums.TipoVenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_VENTA")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_VENTA")
    private Integer idVenta;

    @Column(name="UUID",nullable = false,updatable = false)
    private UUID uuid;

    @Column(name = "IDEMPOTENCIA_KEY",unique = true)
    private String idempotencia_key;

    @Column(name="ID_USUARIO")
    private Integer usuario;

    @Column(name="ID_SUCURSAL")
    private Integer idSucursal;

    @Column(name="FECHA")
    private LocalDateTime fecha;

    @Column(name="TOTAL")
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name="ESTADO")
    private EstadoVenta estado;

    @Enumerated(EnumType.STRING)
    @Column(name="TIPO_VENTA")
    private TipoVenta tipoVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "METODO_ENTREGA")
    private MetodoEntrega metodoEntrega;

    @Column(name = "ESPECIFICACIONES")
    private String especificaciones;
}
