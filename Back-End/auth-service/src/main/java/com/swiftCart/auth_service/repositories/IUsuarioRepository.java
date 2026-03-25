package com.swiftCart.auth_service.repositories;

import com.swiftCart.auth_service.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByUuid(UUID uuid);
    Optional<Usuario> findByTelefono(String telefono);
    Optional<Usuario> findByNroDoc(String nroDoc);
    Optional<Usuario> findByApePaterno(String apePatUsu);
    Optional<Usuario> findByApeMaterno(String apeMatUsu);
}
