package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.service.CarrerasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@Tag(name = "Carreras", description = "Operaciones CRUD sobre las carreras de la academia.")
public class CarrerasController {

    private final CarrerasService carrerasService;

    public CarrerasController(CarrerasService carrerasService) {
        this.carrerasService = carrerasService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las carreras", description = "Retorna una lista de todas las carreras disponibles.")
    @ApiResponse(responseCode = "200", description = "Lista de carreras obtenida con éxito.")
    public ResponseEntity<List<CarrerasDto>> obtenerTodas() {
        List<CarrerasDto> carreras = carrerasService.obtenerTodo();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una carrera por ID", description = "Busca y retorna una carrera específica por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Carrera encontrada y devuelta.")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada.", content = @Content)
    public ResponseEntity<CarrerasDto> obtenerPorId(@Parameter(description = "ID de la carrera a buscar.", example = "1") @PathVariable Long id) {
        CarrerasDto carrera = carrerasService.buscarPorCodigo(id);
        if (carrera == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrera);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva carrera", description = "Crea y guarda una nueva carrera en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Carrera creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CarrerasDto> crear(@Valid @RequestBody CarrerasDto carrerasDto) {
        CarrerasDto creada = carrerasService.guardarCarrera(carrerasDto);
        return ResponseEntity.ok(creada);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una carrera existente", description = "Actualiza la información de una carrera por su ID.")
    @ApiResponse(responseCode = "200", description = "Carrera actualizada con éxito.")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CarrerasDto> modificar(@Parameter(description = "ID de la carrera a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModCarrerasDto modCarrerasDto) {
        CarrerasDto actualizada = carrerasService.modificarCarrera(id, modCarrerasDto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una carrera", description = "Elimina una carrera de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Carrera eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Carrera no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID de la carrera a eliminar.", example = "1") @PathVariable Long id) {
        carrerasService.eliminarCarrera(id);
        return ResponseEntity.noContent().build();
    }
}