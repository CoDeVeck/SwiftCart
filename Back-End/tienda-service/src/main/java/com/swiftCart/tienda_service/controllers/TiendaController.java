package com.swiftCart.tienda_service.controllers;

import com.swiftCart.tienda_service.dto.request.SucursalRequest;
import com.swiftCart.tienda_service.dto.response.ResultadoResponse;
import com.swiftCart.tienda_service.dto.response.SucursalResponse;
import com.swiftCart.tienda_service.models.Sucursal;
import com.swiftCart.tienda_service.services.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/tienda")
@RequiredArgsConstructor
public class TiendaController {

    private final SucursalService sucursalService;


    @GetMapping("/list/{idEmpresa}")
    public ResponseEntity<?> lista(@PathVariable Integer idEmpresa){
        try {
            List<Sucursal> lsita =  sucursalService.listaDeSucursalPorEmpresa(idEmpresa);

            if (lsita.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(lsita);

        }catch ( Exception e){
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al obtener la lista de sucursales."));

        }
    }

    @PostMapping(value = "/new", consumes = {"multipart/form-data"})
    public ResponseEntity<ResultadoResponse<?>>registrarSucursal(@ModelAttribute SucursalRequest request)throws IOException {

        try {
            ResultadoResponse<SucursalResponse> response = sucursalService.registrarSucursal(request);

            if (response.isValor()) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }catch (Exception e){
            return ResponseEntity.status(500)
                    .body(ResultadoResponse.error("Error al crear la nueva sucursal"));
        }
    }

}
