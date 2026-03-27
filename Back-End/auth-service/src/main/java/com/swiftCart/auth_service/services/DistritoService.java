package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.models.Distrito;
import com.swiftCart.auth_service.repositories.IDistritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistritoService {

    private final IDistritoRepository distritoRepository;

    public List<Distrito> listaDistritos() {
        return distritoRepository.findAll();
    }

    public ResultadoResponse<Distrito> obtenerDistrito(Integer id) {
        Distrito distrito = distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se obtuvo el Distrito"));
        return ResultadoResponse.success("Se obtuvo el distrito: ", distrito);
    }

}
