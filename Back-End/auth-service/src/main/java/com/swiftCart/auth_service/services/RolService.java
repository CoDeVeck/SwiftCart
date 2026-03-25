package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.models.Rol;
import com.swiftCart.auth_service.repositories.IRolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {

    private final IRolRepository rolRepository;

    public List<Rol> listaRoles(){
        return rolRepository.findAll();
    }
}
