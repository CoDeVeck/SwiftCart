package com.swiftCart.auth_service.feign.repo;

import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.feign.dto.EmpresaFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tienda-service")
public interface EmpresaFeignClient {

    @GetMapping("/v1/feign/empresa/{id}")
    ResultadoResponse<EmpresaFeign> obtenerEmpresa(@PathVariable Integer id);
}
