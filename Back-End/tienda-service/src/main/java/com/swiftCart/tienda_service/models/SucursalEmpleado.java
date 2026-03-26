package com.swiftCart.tienda_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SUCURSAL_EMPLEADO")
public class SucursalEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUCURSAL_EMPLEADO")
    private Integer idSucursalEmpleado;

    @Column(name = "ID_SUCURSAL")
    private Integer idSucursal;
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Column(name = "INFORME")
    private String informe;
    @Column(name = "FECHA_INGRESO")
    private LocalDateTime fechaIngreso;
    @Column(name = "FECHA_SALIDA")
    private LocalDateTime fechaSalida;
}
