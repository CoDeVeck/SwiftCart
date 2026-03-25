package com.swiftCart.auth_service.controllers;

import com.swiftCart.auth_service.dto.request.RegistrarEmpleadoRequest;
import com.swiftCart.auth_service.dto.request.RegistrarRequest;
import com.swiftCart.auth_service.dto.request.UpdateProfileRequest;
import com.swiftCart.auth_service.dto.response.ProfileResponse;
import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.dto.response.UsuarioResponse;
import com.swiftCart.auth_service.services.CloudinaryService;
import com.swiftCart.auth_service.services.UsuarioService;
import com.swiftCart.auth_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CloudinaryService cloudinaryService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrarEmpleadoRequest request) {
        try {
            ResultadoResponse<UsuarioResponse> registrado = usuarioService.registrarEmpleado(request);

            if (registrado.isValor()) {
                log.info("Se registro al usuario {} exitosamente. ", registrado);
                return ResponseEntity.status(HttpStatus.CREATED).body(registrado);
            } else {
                log.error("No se pudo registrar al usuario {} error!. ", request);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrado);
            }

        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error registrando usuario: " + e.getMessage()));

        }
    }

    @PutMapping(value = "/update/{uuid}", consumes = {"multipart/form-data"})
    public ResponseEntity<ResultadoResponse<?>> update(
            @ModelAttribute UpdateProfileRequest request
    ) {
        try {
            ResultadoResponse<ProfileResponse> response =
                    usuarioService.actualizarPerfil(request);

            if (response.isValor()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al acutalizar al cliente"));
        }
    }
}
