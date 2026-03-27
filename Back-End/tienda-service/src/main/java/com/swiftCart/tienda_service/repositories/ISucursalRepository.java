package com.swiftCart.tienda_service.repositories;

import com.swiftCart.tienda_service.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISucursalRepository extends JpaRepository<Sucursal,Integer> {

    List<Sucursal> findByEmpresa_IdEmpresa(Integer idEmpresa);
}
