package com.swiftCart.delivery_service.repositories;

import com.swiftCart.delivery_service.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido,Integer> {
}
