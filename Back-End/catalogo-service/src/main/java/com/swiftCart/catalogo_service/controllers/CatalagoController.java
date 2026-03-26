package com.swiftCart.catalogo_service.controllers;

import com.swiftCart.catalogo_service.dto.request.CategoriaRequest;
import com.swiftCart.catalogo_service.dto.request.SubCategoriaRequest;
import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.models.Categoria;
import com.swiftCart.catalogo_service.models.SubCategoria;
import com.swiftCart.catalogo_service.services.CategoriaService;
import com.swiftCart.catalogo_service.services.SubCategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/v1/catalogo")
@RequiredArgsConstructor
public class CatalagoController {


    private final CategoriaService categoriaService;
    private final SubCategoriaService subCategoriaService;

    @PostMapping(value = "/categoria", consumes = {"multipart/form-data"})
    public ResponseEntity<?> crearCategoria(
            @ModelAttribute CategoriaRequest categoriaRequest){
      try {
          ResultadoResponse<Categoria> response = categoriaService.crearCategoria(categoriaRequest);
          if (response.isValor()) {
              return ResponseEntity.status(HttpStatus.CREATED).body(response);
          } else {
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
          }
      } catch (IOException e) {
          return ResponseEntity.status(500)
                  .body(ResultadoResponse.error("Error al crear la categoria"));
      }
    }

    @PostMapping("/subCategoria")
    public ResponseEntity<?> crearSubCategoria(@RequestBody SubCategoriaRequest request){
        try{
            ResultadoResponse<SubCategoria> response = subCategoriaService.crearSubCategorias(request);
            if (response.isValor()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }catch (Exception e){
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al crear la subCtegoria"));
        }
    }
}
