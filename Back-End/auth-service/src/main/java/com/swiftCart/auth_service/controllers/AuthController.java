package com.swiftCart.auth_service.controllers;

import com.swiftCart.auth_service.dto.request.LoginRequest;
import com.swiftCart.auth_service.services.CloudinaryService;
import com.swiftCart.auth_service.services.UsuarioService;
import com.swiftCart.auth_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CloudinaryService cloudinaryService;


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

            String token = jwtUtil.generateToken(request.getCorreo(), roles);
            log.info("Se genero el token: {} satisfactoriamente", token);
            return ResponseEntity.ok(Map.of("token",token));

        } catch (Exception e) {
            log.error("Error al logearse {} ", e.getCause());
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }
    }
}
