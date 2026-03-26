package com.swiftCart.auth_service.controllers;

import com.swiftCart.auth_service.dto.request.LoginRequest;
import com.swiftCart.auth_service.dto.request.RegistrarRequest;
import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.dto.response.UsuarioResponse;
import com.swiftCart.auth_service.models.Usuario;
import com.swiftCart.auth_service.repositories.IUsuarioRepository;
import com.swiftCart.auth_service.services.CloudinaryService;
import com.swiftCart.auth_service.services.UsuarioService;
import com.swiftCart.auth_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final IUsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginRequest request){

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getCorreo(),
                            request.getClave()));
            UserDetails details = (UserDetails) auth.getPrincipal();
            List<String> roles = details.getAuthorities().stream().map(
                    GrantedAuthority::getAuthority
            ).collect(Collectors.toList());

            Usuario usuario_cargo = usuarioRepository.findByCorreo(request.getCorreo())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            String cargo = usuario_cargo.getCargo() != null
                    ? usuario_cargo.getCargo().getDescripcion()
                    : null;

            String token = jwtUtil.generateToken(request.getCorreo(), roles,cargo);
            log.info("Se genero el token: {} satisfactoriamente", token);
            return ResponseEntity.ok(Map.of("token",token));

        } catch (Exception e) {
            log.error("Error al logearse {} ", e.getCause());
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegistrarRequest request){
        try {
            ResultadoResponse<UsuarioResponse> registrado = usuarioService.registrarUsuario(request);

            if (registrado.isValor()){
                log.info("Se registro al usuario {} exitosamente. ", registrado);
                return ResponseEntity.status(HttpStatus.CREATED).body(registrado);
            }else{
                log.error("No se pudo registrar al usuario {} error!. ", request);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrado);
            }

        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error registrando usuario: " + e.getMessage()));
        }
    }



}
