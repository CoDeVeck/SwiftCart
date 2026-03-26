package com.swiftCart.catalogo_service.services;

import com.swiftCart.catalogo_service.dto.request.ProductoRequest;
import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.feign.dto.UsuarioFeign;
import com.swiftCart.catalogo_service.feign.repo.UsuarioFeignCatalogo;
import com.swiftCart.catalogo_service.models.Producto;
import com.swiftCart.catalogo_service.models.SubCategoria;
import com.swiftCart.catalogo_service.repositories.IProductoRepository;
import com.swiftCart.catalogo_service.repositories.ISubCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final IProductoRepository productoRepository;
    private final UsuarioFeignCatalogo usuarioFeignCatalogo;
    private final ISubCategoriaRepository subCategoriaRepository;
    private final CloudinaryService cloudinaryService;

    public List<Producto> listaGeneralDeProductosPorEmpresa(Integer idEmpresa){
        return productoRepository.findByIdEmpresa(idEmpresa);
    }

    public ResultadoResponse<Producto> crearProducto(ProductoRequest request) throws IOException {

        Producto guardar = new Producto();
        SubCategoria subCategoria = new SubCategoria();
        subCategoria.setIdSubcategoria(request.getIdSubCategoria());

        guardar.setNombre(request.getNombre());
        guardar.setDescripcion(request.getDescripcion());
        guardar.setIdEmpresa(request.getIdEmpresa());
        guardar.setSubCategoria(subCategoria);

        if(request.getMultipartFile() != null && !request.getMultipartFile().isEmpty()){

            if (guardar.getPublicId() != null){
                cloudinaryService.eliminar(guardar.getPublicId());
            }

            Map<String,String> url_imagen =
                    cloudinaryService.upload(
                            request.getMultipartFile(),"SwiftCart/Productos");
            guardar.setImagen(url_imagen.get("url"));
            guardar.setPublicId(url_imagen.get("public_id"));
        }
        guardar.setFechaRegristro(LocalDateTime.now());
        guardar.setEstado(true);
        productoRepository.save(guardar);

        return ResultadoResponse.success("Se guardo correctamente el producto", guardar);
    }

}
