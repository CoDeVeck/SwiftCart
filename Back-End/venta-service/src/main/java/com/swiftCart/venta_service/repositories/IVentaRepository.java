package com.swiftCart.venta_service.repositories;

import com.swiftCart.venta_service.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Integer> {
}
