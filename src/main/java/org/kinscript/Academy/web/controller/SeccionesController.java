package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.service.SeccionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secciones")
@Tag(name = "Secciones", description = "Operaciones CRUD sobre las secciones de la academia.")
public class SeccionesController {

    private final SeccionesService seccionesService;

    public SeccionesController(SeccionesService seccionesService) {
        this.seccionesService = seccionesService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las secciones", description = "Retorna una lista de todas las secciones registradas.")
    @ApiResponse(responseCode = "200", description = "Lista de secciones obtenida con éxito.")
    public ResponseEntity<List<SeccionesDto>> obtenerTodas() {
        return ResponseEntity.ok(seccionesService.obtenerSeccion());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sección por ID", description = "Busca y retorna una sección específica por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Sección encontrada y devuelta.")
    @ApiResponse(responseCode = "404", description = "Sección no encontrada.", content = @Content)
    public ResponseEntity<SeccionesDto> obtenerPorId(@Parameter(description = "ID de la sección a buscar.", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(seccionesService.buscarSeccion(id));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva sección", description = "Crea y guarda una nueva sección en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Sección creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<SeccionesDto> crear(@RequestBody SeccionesDto seccionesDto) {
        SeccionesDto creado = seccionesService.guardarSeccion(seccionesDto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una sección existente", description = "Modifica la información de una sección por su ID.")
    @ApiResponse(responseCode = "200", description = "Sección actualizada con éxito.")
    @ApiResponse(responseCode = "404", description = "Sección no encontrada.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<SeccionesDto> actualizar(@Parameter(description = "ID de la sección a modificar.", example = "1") @PathVariable Long id, @RequestBody ModSeccionesDto modSeccionesDto) {
        return ResponseEntity.ok(seccionesService.modificarSeccion(id, modSeccionesDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una sección", description = "Elimina una sección de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Sección eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Sección no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID de la sección a eliminar.", example = "1") @PathVariable Long id) {
        seccionesService.eliminarSeccion(id);
        return ResponseEntity.noContent().build();
    }
}