package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.models.Cargo;
import com.swiftCart.auth_service.repositories.ICargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final ICargoRepository cargoRepository;

    public List<Cargo> listaCargo(){
        return cargoRepository.findAll();
    }
}
