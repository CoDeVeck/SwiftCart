package com.swiftCart.tienda_service.feign.repo;

import com.swiftCart.tienda_service.dto.response.ResultadoResponse;
import com.swiftCart.tienda_service.feign.dto.DistritoFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service")
public interface DistritroFeignUsuario {

    @GetMapping("/v1/feign/distrito/{id}")
    ResultadoResponse<DistritoFeign> obtenerDistritoPorId(@PathVariable Integer id);
}
