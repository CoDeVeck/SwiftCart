package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.dto.request.RegistrarEmpleadoRequest;
import com.swiftCart.auth_service.dto.request.RegistrarRequest;
import com.swiftCart.auth_service.dto.response.ResultadoResponse;
import com.swiftCart.auth_service.dto.response.UsuarioResponse;
import com.swiftCart.auth_service.models.Cargo;
import com.swiftCart.auth_service.models.Distrito;
import com.swiftCart.auth_service.models.Rol;
import com.swiftCart.auth_service.models.Usuario;
import com.swiftCart.auth_service.repositories.ICargoRepository;
import com.swiftCart.auth_service.repositories.IDistritoRepository;
import com.swiftCart.auth_service.repositories.IRolRepository;
import com.swiftCart.auth_service.repositories.IUsuarioRepository;
import com.swiftCart.auth_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final IRolRepository rolRepository;
    private final ICargoRepository cargoRepository;
    private final IDistritoRepository distritoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtUtil jwtUtil;

    public Optional<Usuario> obtenerDatos(String correo){
        return usuarioRepository.findByCorreo(correo);
    }
    private UUID generateUUID(){
        return UUID.randomUUID();
    }

    public ResultadoResponse<UsuarioResponse> registrarUsuario(
            RegistrarRequest registrarUsuarioRequest) {

        if (usuarioRepository.findByCorreo(registrarUsuarioRequest.getCorreo()).isPresent()) {
            log.error("Error al registrar el correo {} ya esta en la BD", registrarUsuarioRequest.getCorreo());
            return ResultadoResponse.error("El correo ingresado ya existe, elige otro");
        }

        if (usuarioRepository.findByTelefono(registrarUsuarioRequest.getTelefono()).isPresent()) {
            log.error("Error al registrar el telfono {} ya esta en la BD", registrarUsuarioRequest.getTelefono());
            return ResultadoResponse.error("El teléfono ingresado ya existe, elige otro");
        }

        if (usuarioRepository.findByNroDoc(registrarUsuarioRequest.getNroDoc()).isPresent()) {
            log.error("Error al registrar el DNI  {} ya esta en la BD", registrarUsuarioRequest.getNroDoc());
            return ResultadoResponse.error("El N°: " + registrarUsuarioRequest.getNroDoc() + " ya fue registrado, elige otro");
        }
        Usuario usuarioNuevo = registerUserMap(registrarUsuarioRequest);

        usuarioRepository.save(usuarioNuevo);
        UsuarioResponse response = usuarioDTO(usuarioNuevo);

        return ResultadoResponse.success("Se registro al usuario", response);


    }

    private Usuario registerUserMap(
            RegistrarRequest request){

        Usuario usuario = new Usuario();
        Rol rolDefault = rolRepository.getReferenceById(2);

        Distrito distritoSeleccionado =
                distritoRepository.getReferenceById(request.getIdDistrito());
        usuario.setUuid(generateUUID());
        usuario.setNombres(request.getNombres());
        usuario.setApePaterno(request.getApePaterno());
        usuario.setApeMaterno(request.getApeMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setClave(bCryptPasswordEncoder.encode(request.getClave()));
        usuario.setTipoDoc(request.getTipoDoc());
        usuario.setNroDoc(request.getNroDoc());
        usuario.setDireccion(request.getDireccion());
        usuario.setDistrito(distritoSeleccionado);
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(rolDefault);
        usuario.setCargo(null);
        usuario.setFechaRegistro(LocalDateTime.now());

        return usuario;
    }


    public ResultadoResponse<UsuarioResponse> registrarEmpleado(
            RegistrarEmpleadoRequest request
    ){
        if (usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
            log.error("Error al registrar el correo {} ya esta en la BD", request.getCorreo());
            return ResultadoResponse.error("El correo ingresado ya existe, elige otro");
        }

        if (usuarioRepository.findByTelefono(request.getTelefono()).isPresent()) {
            log.error("Error al registrar el telfono {} ya esta en la BD", request.getTelefono());
            return ResultadoResponse.error("El teléfono ingresado ya existe, elige otro");
        }

        if (usuarioRepository.findByNroDoc(request.getNroDoc()).isPresent()) {
            log.error("Error al registrar el DNI  {} ya esta en la BD", request.getNroDoc());
            return ResultadoResponse.error("El N°: " + request.getNroDoc() + " ya fue registrado, elige otro");
        }
        Usuario usuarioNuevo = registerEmpleadoMap(request);

        usuarioRepository.save(usuarioNuevo);
        UsuarioResponse response = usuarioDTO(usuarioNuevo);

        return ResultadoResponse.success("Se registro al usuario", response);
    }
    private Usuario registerEmpleadoMap(
            RegistrarEmpleadoRequest request){

        Usuario usuario = new Usuario();
        Rol rolDefault = rolRepository.getReferenceById(4);
        Cargo cargo = cargoRepository.getReferenceById(request.getIdCargo());

        Distrito distritoSeleccionado =
                distritoRepository.getReferenceById(request.getIdDistrito());
        usuario.setUuid(generateUUID());
        usuario.setNombres(request.getNombres());
        usuario.setApePaterno(request.getApePaterno());
        usuario.setApeMaterno(request.getApeMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setClave(bCryptPasswordEncoder.encode(request.getClave()));
        usuario.setTipoDoc(request.getTipoDoc());
        usuario.setNroDoc(request.getNroDoc());
        usuario.setDireccion(request.getDireccion());
        usuario.setDistrito(distritoSeleccionado);
        usuario.setTelefono(request.getTelefono());
        usuario.setRol(rolDefault);
        usuario.setCargo(cargo);
        usuario.setFechaRegistro(LocalDateTime.now());

        return usuario;
    }


    private UsuarioResponse usuarioDTO(Usuario usuario){
        UsuarioResponse userDto = new UsuarioResponse();
        userDto.setUuid(usuario.getUuid());
        userDto.setNombres(usuario.getNombres());
        userDto.setApellidos(usuario.getApePaterno() + " " + usuario.getApeMaterno());
        userDto.setCorreo(usuario.getCorreo());
        userDto.setTelefono(usuario.getTelefono());
        userDto.setDistrito(usuario.getDistrito().getNombre());

        return userDto;
    }
}
