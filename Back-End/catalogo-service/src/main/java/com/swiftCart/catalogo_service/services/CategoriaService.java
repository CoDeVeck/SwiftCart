package com.swiftCart.catalogo_service.services;

import com.swiftCart.catalogo_service.dto.request.CategoriaRequest;
import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.models.Categoria;
import com.swiftCart.catalogo_service.repositories.ICategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final ICategoriaRepository categoriaRepository;
    private final CloudinaryService cloudinaryService;

    public List<Categoria>listaCategorias(){
        return  categoriaRepository.findAll();
    }

    public ResultadoResponse<Categoria> crearCategoria(CategoriaRequest request) throws IOException {

        Categoria categoria = new Categoria();
        categoria.setDescripcion(request.getDescripcion());
        Map<String,String> url_imagen =
                cloudinaryService.upload(
                        request.getMultipartFile(), "SwiftCart/Categorias");
        categoria.setImagen(url_imagen.get("url"));
        categoria.setPublicId(url_imagen.get("public_id"));
        categoriaRepository.save(categoria);
        return ResultadoResponse.success("Se creo la nueva categoria",categoria);
    }
}
