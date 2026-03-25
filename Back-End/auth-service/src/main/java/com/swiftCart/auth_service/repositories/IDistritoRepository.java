package com.swiftCart.auth_service.repositories;

import com.swiftCart.auth_service.models.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Integer> {
}
