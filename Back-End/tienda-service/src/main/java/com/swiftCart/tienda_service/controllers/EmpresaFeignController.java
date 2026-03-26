package com.swiftCart.tienda_service.controllers;

import com.swiftCart.tienda_service.dto.response.ResultadoResponse;
import com.swiftCart.tienda_service.models.Empresa;
import com.swiftCart.tienda_service.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/feign/empresa")
@RequiredArgsConstructor
public class EmpresaFeignController {

    private final EmpresaService empresaService;

    @GetMapping("/all")
    public ResponseEntity<?> lista(){
        return ResponseEntity.ok(empresaService.listaDeEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEmpresa(@PathVariable Integer id){
        try {
            ResultadoResponse<Empresa> empresa = empresaService.obtenerEmpresaPorId(id);

            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error registrando usuario: " + e.getMessage()));
        }
    }

}
