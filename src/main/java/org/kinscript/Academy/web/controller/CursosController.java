package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.service.CursosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Cursos", description = "Operaciones CRUD sobre los cursos de la academia.")
public class CursosController {

    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los cursos", description = "Retorna una lista de todos los cursos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de cursos obtenida con éxito.")
    public ResponseEntity<List<CursosDto>> obtenerTodos() {
        List<CursosDto> cursos = cursosService.obtenerTodo();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un curso por ID", description = "Busca y retorna un curso específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Curso encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado.", content = @Content)
    public ResponseEntity<CursosDto> obtenerPorId(@Parameter(description = "ID del curso a buscar.", example = "1") @PathVariable Long id) {
        CursosDto curso = cursosService.buscarPorCodigo(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo curso", description = "Crea y guarda un nuevo curso en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Curso creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CursosDto> crear(@Valid @RequestBody CursosDto cursosDto) {
        CursosDto creado = cursosService.guardarCursos(cursosDto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un curso existente", description = "Actualiza la información de un curso por su ID.")
    @ApiResponse(responseCode = "200", description = "Curso actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<CursosDto> modificar(@Parameter(description = "ID del curso a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModCursosDto modCursosDto) {
        CursosDto actualizado = cursosService.modificarCursos(id, modCursosDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un curso", description = "Elimina un curso de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Curso eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID del curso a eliminar.", example = "1") @PathVariable Long id) {
        cursosService.eliminarCursos(id);
        return ResponseEntity.noContent().build();
    }
}