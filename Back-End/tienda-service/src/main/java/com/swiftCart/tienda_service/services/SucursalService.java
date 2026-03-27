package com.swiftCart.tienda_service.services;

import com.swiftCart.tienda_service.dto.request.SucursalRequest;
import com.swiftCart.tienda_service.dto.response.ResultadoResponse;
import com.swiftCart.tienda_service.dto.response.SucursalResponse;
import com.swiftCart.tienda_service.feign.dto.DistritoFeign;
import com.swiftCart.tienda_service.feign.repo.DistritroFeignUsuario;
import com.swiftCart.tienda_service.models.Empresa;
import com.swiftCart.tienda_service.models.Sucursal;
import com.swiftCart.tienda_service.repositories.IEmpresaRepository;
import com.swiftCart.tienda_service.repositories.ISucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SucursalService {

    private final ISucursalRepository sucursalRepository;
    private final CloudinaryService cloudinaryService;
    private final IEmpresaRepository empresaRepository;
    private final DistritroFeignUsuario distritroFeignUsuario;

    public List<Sucursal> listaDeSucursalPorEmpresa(Integer idEmpresa) {
        return sucursalRepository.findByEmpresa_IdEmpresa(idEmpresa);
    }

    public ResultadoResponse<SucursalResponse>
    registrarSucursal(SucursalRequest request) throws IOException {

        Sucursal registrar = registrarMap(request);
        sucursalRepository.save(registrar);

        SucursalResponse response = response(registrar);


        return ResultadoResponse.success("Se registro la sucursal. ", response);

    }

    private Sucursal registrarMap(SucursalRequest request) throws IOException {
        Sucursal guardar = new Sucursal();
        guardar.setNombreUbicacion(request.getNombreUbicacion());
        Empresa empresa = new Empresa();
        empresa.setIdEmpresa(request.getIdEmpresa());

        guardar.setEmpresa(empresa);
        if (request.getMultipartFile() != null && !request.getMultipartFile().isEmpty()) {
            Map<String, String> url_imagen =
                    cloudinaryService.upload(
                            request.getMultipartFile(),
                            "SwiftCart/Sucursales");
            guardar.setImagen(url_imagen.get("url"));
            guardar.setPublicId(url_imagen.get("public_id"));
        }
        guardar.setIdDistrito(request.getIdDistrito());
        guardar.setDireccion(request.getDireccion());
        guardar.setFechaApertura(request.getFechaApertura());

        return guardar;
    }

    private SucursalResponse response(Sucursal request) {
        SucursalResponse response = new SucursalResponse();
        response.setNombreUbicacion(request.getNombreUbicacion());
        Empresa empresa = empresaRepository.getReferenceById(request.getEmpresa().getIdEmpresa());

        response.setNombreEmpresa(empresa.getRazoSocial());

        ResultadoResponse<DistritoFeign> distrito = distritroFeignUsuario.obtenerDistritoPorId(request.getIdDistrito());
        var distritoData = distrito.getData();

        response.setImagen(request.getImagen());
        response.setNombreDistrito(distritoData.getNombre());
        response.setDireccion(request.getDireccion());
        response.setFechaApertura(request.getFechaApertura().toString());

        return response;
    }

}
