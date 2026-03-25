package com.swiftCart.delivery_service.models;
import com.swiftCart.delivery_service.enums.EstadoPedido;
import com.swiftCart.delivery_service.enums.TipoMovilidad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer idPedido;

    @Column(name="UUID",nullable = false,updatable = false)
    private UUID uuid;

    @Column(name = "ID_VENTA")
    private Integer idVenta;

    @Column(name = "ID_SUCURSAL")
    private Integer idSucursal;

    @CreationTimestamp
    @Column(name = "FECHA_CREACION")
    private LocalDateTime fecha;

    @Column(name = "DIRECCION_ENTREGA")
    private String direccionEntrega;

    @Column(name = "LATITUD")
    private BigDecimal latitud;

    @Column(name = "LONGITUD")
    private BigDecimal longitud;

    @Column(name = "NUMERO_PEDIDO")
    private String numPedido;

    @Column(name = "QR_VERIFICATION_CODE")
    private String qrVerificacion;

    @Column(name="ID_REPARTIDOR")
    private Integer idRepartidor;

    @Enumerated(EnumType.STRING)
    @Column(name = "MOVILIDAD")
    private TipoMovilidad movilidad;

    @Column(name = "FECHA_ASIGNACION")
    private LocalDateTime fechaAsignacion;

    @Column(name = "FECHA_EN_CAMINO")
    private LocalDateTime fechaEnCamino;

    @Column(name = "FECHA_ENTREGA")
    private LocalDateTime fechaEntregado;

    @Column(name = "TIEMPO_ENTREGA_MINUTOS")
    private Short tiempoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO")
    private EstadoPedido estado;

    @Column(name = "OBSERVACIONES")
    private String observaciones;
}
