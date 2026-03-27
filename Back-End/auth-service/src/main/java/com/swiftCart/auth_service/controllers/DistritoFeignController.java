package com.swiftCart.auth_service.controllers;

import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.models.Distrito;
import com.swiftCart.auth_service.services.DistritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/feign/distrito")
@RequiredArgsConstructor
public class DistritoFeignController {

    private final DistritoService distritoService;

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoResponse<?>> obtenerDistrito(@PathVariable Integer id) {
        try {
            ResultadoResponse<Distrito> response = distritoService.obtenerDistrito(id);

            if (response.isValor()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al obtener el distrito"));
        }
    }

}
