package com.swiftCart.tienda_service.services;


import com.swiftCart.tienda_service.models.Empresa;
import com.swiftCart.tienda_service.repositories.IEmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final IEmpresaRepository empresaRepository;


    public List<Empresa> listaDeEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa obtenerEmpresaPorId(Integer id ){
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la empresa"));
    }
}
