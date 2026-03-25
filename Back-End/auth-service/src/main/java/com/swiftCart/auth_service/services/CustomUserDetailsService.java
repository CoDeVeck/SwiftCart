package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.models.Usuario;
import com.swiftCart.auth_service.repositories.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario u =  usuarioRepository.findByCorreo(username).
                orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return User.withUsername(u.getCorreo())
                .password(u.getClave())
                .roles(u.getRol().getDescripcion().replace("ROLE_",""))
                .build();
    }
}
