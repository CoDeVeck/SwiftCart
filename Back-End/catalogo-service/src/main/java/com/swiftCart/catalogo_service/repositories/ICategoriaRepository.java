package com.swiftCart.catalogo_service.repositories;

import com.swiftCart.catalogo_service.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria,Integer> {
}
