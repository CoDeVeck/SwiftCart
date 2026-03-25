package com.swiftCart.venta_service.repositories;

import com.swiftCart.venta_service.models.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
}
