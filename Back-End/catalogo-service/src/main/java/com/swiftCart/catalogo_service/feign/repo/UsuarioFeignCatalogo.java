package com.swiftCart.catalogo_service.feign.repo;

import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.feign.dto.UsuarioFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name="auth-service")

public interface UsuarioFeignCatalogo {
    @GetMapping("/v1/usuario/profile/{uuid}")
    ResultadoResponse<UsuarioFeign> obtenerUsuario(@PathVariable UUID uuid);
}
