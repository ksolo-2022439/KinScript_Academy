package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.service.ProfesoresService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@Tag(name = "Profesores", description = "Operaciones CRUD sobre los profesores de la academia.")
public class ProfesoresController {

    private final ProfesoresService profesoresService;

    public ProfesoresController(ProfesoresService profesoresService) {
        this.profesoresService = profesoresService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los profesores", description = "Retorna una lista de todos los profesores registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de profesores obtenida con éxito.")
    public ResponseEntity<List<ProfesoresDto>> obtenerTodos() {
        List<ProfesoresDto> profesores = profesoresService.obtenerTodo();
        return ResponseEntity.ok(profesores);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un profesor por ID", description = "Busca y retorna un profesor específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Profesor encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Profesor no encontrado.", content = @Content)
    public ResponseEntity<ProfesoresDto> obtenerPorId(@Parameter(description = "ID del profesor a buscar.", example = "1") @PathVariable Long id) {
        ProfesoresDto profesor = profesoresService.buscarPorId(id);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesor);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo profesor", description = "Crea y guarda un nuevo profesor en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Profesor creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<ProfesoresDto> crear(@Valid @RequestBody ProfesoresDto profesoresDto) {
        ProfesoresDto creado = profesoresService.guardarProfesor(profesoresDto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un profesor existente", description = "Actualiza la información de un profesor por su ID.")
    @ApiResponse(responseCode = "200", description = "Profesor actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Profesor no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<ProfesoresDto> modificar(@Parameter(description = "ID del profesor a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModProfesoresDto modProfesoresDto) {
        ProfesoresDto actualizado = profesoresService.modificarProfesor(id, modProfesoresDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un profesor", description = "Elimina un profesor de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Profesor eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Profesor no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID del profesor a eliminar.", example = "1") @PathVariable Long id) {
        profesoresService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }
}