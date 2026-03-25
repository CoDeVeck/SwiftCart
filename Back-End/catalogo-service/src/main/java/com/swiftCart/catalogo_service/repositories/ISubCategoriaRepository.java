package com.swiftCart.catalogo_service.repositories;

import com.swiftCart.catalogo_service.models.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubCategoriaRepository extends JpaRepository<SubCategoria,Integer> {
}
