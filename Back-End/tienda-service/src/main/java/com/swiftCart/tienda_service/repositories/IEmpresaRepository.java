package com.swiftCart.tienda_service.repositories;

import com.swiftCart.tienda_service.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {
}
