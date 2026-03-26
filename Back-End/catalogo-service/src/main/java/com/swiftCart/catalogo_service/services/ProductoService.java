package com.swiftCart.catalogo_service.services;

import com.swiftCart.catalogo_service.feign.repo.UsuarioFeignCatalogo;
import com.swiftCart.catalogo_service.models.Producto;
import com.swiftCart.catalogo_service.repositories.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final IProductoRepository productoRepository;
    private final UsuarioFeignCatalogo usuarioFeignCatalogo;

    public List<Producto> listaGeneralDeProductosPorEmpresa(Integer idEmpresa){
        return productoRepository.findByIdEmpresa(idEmpresa);
    }
}
