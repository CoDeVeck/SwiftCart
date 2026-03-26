package com.swiftCart.catalogo_service.services;

import com.swiftCart.catalogo_service.dto.request.SubCategoriaRequest;
import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.models.Categoria;
import com.swiftCart.catalogo_service.models.SubCategoria;
import com.swiftCart.catalogo_service.repositories.ICategoriaRepository;
import com.swiftCart.catalogo_service.repositories.ISubCategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoriaService {

    private final ISubCategoriaRepository subCategoriaRepository;
    private final ICategoriaRepository categoriaRepository;


    public List<SubCategoria> listaSubCategoria(){
        return subCategoriaRepository.findAll();
    }

    public ResultadoResponse<SubCategoria> crearSubCategorias(SubCategoriaRequest request){

        SubCategoria guardar = new SubCategoria();
        guardar.setNombre(request.getNombre());

        Categoria categoria = new Categoria();
        categoria.setIdCategoria(request.getIdCategoria());
        guardar.setCategoria(categoria);

        subCategoriaRepository.save(guardar);
        return ResultadoResponse.success("Se creo la subcategoria. ", guardar);
    }
}
