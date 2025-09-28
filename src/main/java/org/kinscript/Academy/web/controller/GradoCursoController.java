package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.service.GradoCursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gradocursos")
@Tag(name = "Grado-Cursos", description = "Operaciones para asociar y gestionar la relación entre grados y cursos.")
public class GradoCursoController {

    private final GradoCursoService gradoCursoService;

    public GradoCursoController(GradoCursoService gradoCursoService) {
        this.gradoCursoService = gradoCursoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las asociaciones de grados y cursos", description = "Retorna una lista completa de todas las asociaciones existentes.")
    @ApiResponse(responseCode = "200", description = "Lista de asociaciones obtenida con éxito.")
    public ResponseEntity<List<GradoCursoDto>> obtenerTodos() {
        return ResponseEntity.ok(gradoCursoService.obtenerTodo());
    }

    @GetMapping("/grado/{idGrado}")
    @Operation(summary = "Obtener cursos por grado", description = "Retorna una lista de los cursos asociados a un grado específico.")
    @ApiResponse(responseCode = "200", description = "Lista de cursos por grado obtenida con éxito.")
    @ApiResponse(responseCode = "404", description = "Grado no encontrado.", content = @Content)
    public ResponseEntity<List<GradoCursoDto>> obtenerPorGrado(@Parameter(description = "ID del grado para el cual se buscan los cursos.") @PathVariable Long idGrado) {
        return ResponseEntity.ok(gradoCursoService.obtenerCursosPorGrado(idGrado));
    }

    @PostMapping
    @Operation(summary = "Crear una nueva asociación entre un grado y un curso", description = "Asocia un grado existente con un curso existente.")
    @ApiResponse(responseCode = "201", description = "Asociación creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o asociación ya existe.", content = @Content)
    public ResponseEntity<GradoCursoDto> crearAsociacion(@Valid @RequestBody GradoCursoDto gradoCursoDto) {
        return new ResponseEntity<>(gradoCursoService.guardarAsociacion(gradoCursoDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/grado/{idGrado}/curso/{idCurso}")
    @Operation(summary = "Eliminar una asociación entre un grado y un curso", description = "Desvincula un curso de un grado específico.")
    @ApiResponse(responseCode = "204", description = "Asociación eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Asociación no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminarAsociacion(
            @Parameter(description = "ID del grado.") @PathVariable Long idGrado,
            @Parameter(description = "ID del curso.") @PathVariable Long idCurso) {
        gradoCursoService.eliminarAsociacion(idGrado, idCurso);
        return ResponseEntity.noContent().build();
    }
}