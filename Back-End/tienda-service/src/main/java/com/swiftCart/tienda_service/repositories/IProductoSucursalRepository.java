package com.swiftCart.tienda_service.repositories;

import com.swiftCart.tienda_service.models.ProductoSucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoSucursalRepository extends JpaRepository<ProductoSucursal,Integer> {
}
