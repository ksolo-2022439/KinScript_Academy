package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("/coordinadores")
@Tag(name = "Coordinadores", description = "Operaciones CRUD sobre los coordinadores de la academia.")
public class CoordinadoresController {

    private final CoordinadoresService coordinadoresService;

    public CoordinadoresController(CoordinadoresService coordinadoresService) {
        this.coordinadoresService = coordinadoresService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los coordinadores", description = "Retorna una lista de todos los coordinadores registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de coordinadores obtenida con éxito.")
    public ResponseEntity<List<CoordinadoresDto>> obtenerTodos() {
        return ResponseEntity.ok(coordinadoresService.obtenerTodo());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un coordinador por ID", description = "Busca y retorna un coordinador específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Coordinador encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Coordinador no encontrado.", content = @Content)
    public ResponseEntity<CoordinadoresDto> obtenerPorId(@Parameter(description = "ID del coordinador a buscar.", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(coordinadoresService.buscarPorCodigo(id));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo coordinador", description = "Crea y guarda un nuevo coordinador en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Coordinador creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CoordinadoresDto> crear(@Valid @RequestBody CoordinadoresDto coordinadoresDto) {
        return new ResponseEntity<>(coordinadoresService.guardarCoordinador(coordinadoresDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un coordinador existente", description = "Actualiza la información de un coordinador por su ID.")
    @ApiResponse(responseCode = "200", description = "Coordinador actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Coordinador no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CoordinadoresDto> modificar(@Parameter(description = "ID del coordinador a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModCoordinadoresDto modCoordinadoresDto) {
        return ResponseEntity.ok(coordinadoresService.modificarCoordinador(id, modCoordinadoresDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un coordinador", description = "Elimina un coordinador de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Coordinador eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Coordinador no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID del coordinador a eliminar.", example = "1") @PathVariable Long id) {
        coordinadoresService.eliminarCoordinador(id);
        return ResponseEntity.noContent().build();
    }
}