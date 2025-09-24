package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.dominio.service.ProfesorAsignacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor-asignaciones")
@Tag(name = "Asignaciones de Profesores", description = "Operaciones para gestionar la asignación de cursos a profesores.")
public class ProfesorAsignacionController {

    private final ProfesorAsignacionService asignacionService;

    public ProfesorAsignacionController(ProfesorAsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las asignaciones", description = "Retorna una lista de todas las asignaciones de cursos a profesores.")
    @ApiResponse(responseCode = "200", description = "Lista de asignaciones obtenida con éxito.")
    public ResponseEntity<List<ProfesorAsignacionDto>> obtenerTodas() {
        return ResponseEntity.ok(asignacionService.obtenerTodo());
    }

    @GetMapping("/profesor/{idProfesor}")
    @Operation(summary = "Obtener asignaciones por profesor", description = "Busca y retorna las asignaciones de un profesor específico.")
    @ApiResponse(responseCode = "200", description = "Asignaciones del profesor obtenidas con éxito.")
    @ApiResponse(responseCode = "404", description = "Profesor no encontrado o sin asignaciones.", content = @Content)
    public ResponseEntity<List<ProfesorAsignacionDto>> obtenerPorProfesor(@Parameter(description = "ID del profesor para el que se buscan las asignaciones.") @PathVariable Long idProfesor) {
        return ResponseEntity.ok(asignacionService.obtenerAsignacionesPorProfesor(idProfesor));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva asignación", description = "Asigna un curso a un profesor existente.")
    @ApiResponse(responseCode = "201", description = "Asignación creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o asignación ya existente.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<ProfesorAsignacionDto> crearAsignacion(@Valid @RequestBody ProfesorAsignacionDto asignacionDto) {
        return new ResponseEntity<>(asignacionService.guardarAsignacion(asignacionDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    @Operation(summary = "Eliminar una asignación", description = "Elimina una asignación de curso a profesor.")
    @ApiResponse(responseCode = "204", description = "Asignación eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Asignación no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminarAsignacion(@Valid @RequestBody ProfesorAsignacionDto asignacionDto) {
        asignacionService.eliminarAsignacion(asignacionDto);
        return ResponseEntity.noContent().build();
    }
}