package com.swiftCart.catalogo_service.repositories;

import com.swiftCart.catalogo_service.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByIdEmpresa(Integer idEmpresa);
}
