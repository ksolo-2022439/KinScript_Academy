package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.service.CoordinadoresService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/coordinadores")
@Tag(name = "Coordinadores",
        description= "gestion de coordinadorees")
public class CoordinadoresController {
    private final CoordinadoresService coordinadoresService;


    public CoordinadoresController(CoordinadoresService coordinadoresService) {
        this.coordinadoresService = coordinadoresService;
    }

    @GetMapping
    public ResponseEntity<List<CoordinadoresDto>> obtenerCoordinador() {
        return ResponseEntity.ok(coordinadoresService.obtenerCoordinador());
    }


    @PostMapping
    public ResponseEntity<CoordinadoresDto> guadarCoordinador(@RequestBody @Valid CoordinadoresDto coordinadoresDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.coordinadoresService.guardarCoordinador(coordinadoresDto));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<CoordinadoresDto> modificarCoordinador(@PathVariable Long codigo, @RequestBody ModCoordinadoresDto modCoordinadores) {
        return ResponseEntity.ok(this.coordinadoresService.modificarCoordinador(codigo, modCoordinadores));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarCoordinador(@PathVariable Long codigo) {
        this.coordinadoresService.eliminarCoordinador(codigo);
        return ResponseEntity.ok().build();

    }

    @GetMapping("{codigo}")
    @Operation(summary = "Obtener un coordinador por su identificador",
            description = "Retorna el coordinador que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Coordinador encontrado"),
                    @ApiResponse(responseCode = "404", description = "Coordinador no encontrado", content = @Content)
            })

    public ResponseEntity<CoordinadoresDto> buscarPorCodigo
            (@Parameter(description = "Identificador del Coordinador a buscar", example = "7")
             @PathVariable Long codigo){
        return ResponseEntity.ok(this.coordinadoresService.buscarCoordinador(codigo));
    }
}