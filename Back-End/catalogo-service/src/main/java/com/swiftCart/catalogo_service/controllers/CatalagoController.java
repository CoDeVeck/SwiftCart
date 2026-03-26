package com.swiftCart.catalogo_service.controllers;

import com.swiftCart.catalogo_service.dto.request.CategoriaRequest;
import com.swiftCart.catalogo_service.dto.request.ProductoRequest;
import com.swiftCart.catalogo_service.dto.request.SubCategoriaRequest;
import com.swiftCart.catalogo_service.dto.response.ResultadoResponse;
import com.swiftCart.catalogo_service.models.Categoria;
import com.swiftCart.catalogo_service.models.Producto;
import com.swiftCart.catalogo_service.models.SubCategoria;
import com.swiftCart.catalogo_service.services.CategoriaService;
import com.swiftCart.catalogo_service.services.ProductoService;
import com.swiftCart.catalogo_service.services.SubCategoriaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/catalogo")
@RequiredArgsConstructor
public class CatalagoController {


    private final CategoriaService categoriaService;
    private final SubCategoriaService subCategoriaService;
    private final ProductoService productoService;

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

    @GetMapping("/productos/{idEmpresa}")
    public ResponseEntity<?> obtenerListaDeProductos(@PathVariable Integer idEmpresa){

        try {
            List<Producto> listaDeProductos = productoService.listaGeneralDeProductosPorEmpresa(idEmpresa);
            if (listaDeProductos.isEmpty()){
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(listaDeProductos);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al obtener la lista de productos."));
        }
    }

    @PostMapping(value = "/producto",consumes = {"multipart/form-data"})
    public ResponseEntity<ResultadoResponse<?>> registrarProducto(@ModelAttribute ProductoRequest request){
        try {
            ResultadoResponse<Producto> response = productoService.crearProducto(request);
            if (response.isValor()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al crear el Producto"));
        }
    }
}
