package com.swiftCart.tienda_service.repositories;

import com.swiftCart.tienda_service.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalRepository extends JpaRepository<Sucursal,Integer> {
}
