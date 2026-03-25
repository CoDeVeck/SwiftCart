package com.swiftCart.auth_service.services;

import com.swiftCart.auth_service.dto.request.RegistrarEmpleadoRequest;
import com.swiftCart.auth_service.dto.request.RegistrarRequest;
import com.swiftCart.auth_service.dto.request.UpdateProfileRequest;
import com.swiftCart.auth_service.dto.response.ProfileResponse;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
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
    private final CloudinaryService cloudinaryService;
    private final JwtUtil jwtUtil;

    public Optional<Usuario> obtenerDatos(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

    public ResultadoResponse<UsuarioResponse> registrarUsuario(
            RegistrarRequest registrarUsuarioRequest) {

        validarUsuario(
                registrarUsuarioRequest.getCorreo(),
                registrarUsuarioRequest.getTelefono(),
                registrarUsuarioRequest.getNroDoc());
        Usuario usuarioNuevo = registerUserMap(registrarUsuarioRequest);

        usuarioRepository.save(usuarioNuevo);
        UsuarioResponse response = usuarioDTO(usuarioNuevo);

        return ResultadoResponse.success("Se registro al usuario", response);


    }

    private Usuario registerUserMap(
            RegistrarRequest request) {

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
    ) {
        validarUsuario(request.getCorreo(), request.getTelefono(), request.getNroDoc());
        Usuario usuarioNuevo = registerEmpleadoMap(request);

        usuarioRepository.save(usuarioNuevo);
        UsuarioResponse response = usuarioDTO(usuarioNuevo);

        return ResultadoResponse.success("Se registro al usuario", response);
    }

    private Usuario registerEmpleadoMap(
            RegistrarEmpleadoRequest request) {

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

    private UsuarioResponse usuarioDTO(Usuario usuario) {
        UsuarioResponse userDto = new UsuarioResponse();
        userDto.setUuid(usuario.getUuid());
        userDto.setNombres(usuario.getNombres());
        userDto.setApellidos(usuario.getApePaterno() + " " + usuario.getApeMaterno());
        userDto.setCorreo(usuario.getCorreo());
        userDto.setTelefono(usuario.getTelefono());
        userDto.setDistrito(usuario.getDistrito().getNombre());

        return userDto;
    }

    private Usuario obtenerUsuarioPorUuid(UUID uuid) {
        return usuarioRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("No se encontro al usuario!"));
    }

    public ResultadoResponse<ProfileResponse> actualizarPerfil
            (UpdateProfileRequest request) throws IOException {

        Usuario usuario = obtenerUsuarioPorUuid(request.getUuid());

        if (!usuario.getCorreo().equals(request.getCorreo()) &&
                usuarioRepository.findByCorreo(request.getCorreo()).isPresent()) {
            return ResultadoResponse.error("El correo ya existe");
        }
        if (!usuario.getTelefono().equals(request.getTelefono()) &&
                usuarioRepository.findByTelefono(request.getTelefono()).isPresent()) {
            return ResultadoResponse.error("El telfono ya existe");
        }
        if (!usuario.getNroDoc().equals(request.getNroDoc()) &&
                usuarioRepository.findByNroDoc(request.getNroDoc()).isPresent()) {
            return ResultadoResponse.error("El DNI ya existe");
        }

        usuario.setNombres(request.getNombres());
        usuario.setApePaterno(request.getApePaterno());
        usuario.setApeMaterno(request.getApeMaterno());
        usuario.setCorreo(request.getCorreo());
        usuario.setTipoDoc(request.getTipoDoc());
        usuario.setNroDoc(request.getNroDoc());

        Distrito actualizar = distritoRepository.getReferenceById(request.getIdDistrito());
        usuario.setDistrito(actualizar);
        usuario.setTelefono(request.getTelefono());

        if (request.getImagenMultipart() != null && !request.getImagenMultipart().isEmpty()) {

            if (usuario.getPublicId() != null) {
                cloudinaryService.eliminar(usuario.getPublicId());
            }

            Map<String, String> url_imagen =
                    cloudinaryService.upload(request.getImagenMultipart(), "SwiftCart/Usuarios");
            usuario.setImagen(url_imagen.get("url"));
            usuario.setPublicId(url_imagen.get("public_id"));
        }

        usuarioRepository.save(usuario);
        ProfileResponse response = responseProfile(usuario);

        return ResultadoResponse.success("Se actualizo al usuario. ", response);
    }

    private ProfileResponse responseProfile(Usuario usuari) {

        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setUuid(usuari.getUuid());
        profileResponse.setNombres(usuari.getNombres());
        profileResponse.setApePaterno(usuari.getApePaterno());
        profileResponse.setApeMaterno(usuari.getApeMaterno());
        profileResponse.setCorreo(usuari.getCorreo());
        profileResponse.setTipoDoc(usuari.getTipoDoc());
        profileResponse.setNroDoc(usuari.getNroDoc());
        profileResponse.setDireccion(usuari.getDireccion());
        if (usuari.getDistrito() != null) {
            profileResponse.setNombreDistrito(usuari.getDistrito().getNombre());
        }
        profileResponse.setTelefono(usuari.getTelefono());
        profileResponse.setImagen(usuari.getImagen());
        return profileResponse;

    }

    private void validarUsuario(String correo, String telefono, String nroDoc) {
        if (usuarioRepository.findByCorreo(correo).isPresent()) {
            log.error("El correo {} ya existe intente con otro", correo);
            throw new RuntimeException("El correo ya existe");
        }

        if (usuarioRepository.findByTelefono(telefono).isPresent()) {
            log.error("El telefono {} ya existe intente con otro", telefono);
            throw new RuntimeException("El teléfono ya existe");
        }

        if (usuarioRepository.findByNroDoc(nroDoc).isPresent()) {
            log.error("El Documento {} ya existe intente con otro", nroDoc);
            throw new RuntimeException("El documento ya existe");
        }
    }
}
