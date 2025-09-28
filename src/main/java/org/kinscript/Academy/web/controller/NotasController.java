package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;
import org.kinscript.Academy.dominio.service.NotasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@Tag(name = "Notas", description = "Operaciones CRUD sobre las notas de los alumnos.")
public class NotasController {

    private final NotasService notasService;

    public NotasController(NotasService notasService) {
        this.notasService = notasService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las notas", description = "Retorna una lista de todas las notas de los alumnos registradas.")
    @ApiResponse(responseCode = "200", description = "Lista de notas obtenida con éxito.")
    public ResponseEntity<List<NotasDto>> obtenerTodas() {
        return ResponseEntity.ok(notasService.obtenerTodo());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una nota por ID", description = "Busca y retorna una nota específica por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Nota encontrada y devuelta.")
    @ApiResponse(responseCode = "404", description = "Nota no encontrada.", content = @Content)
    public ResponseEntity<NotasDto> obtenerPorId(@Parameter(description = "ID de la nota a buscar.", example = "1") @PathVariable Long id) {
        return ResponseEntity.ok(notasService.buscarPorCodigo(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    @Operation(summary = "Obtener notas por ID de alumno", description = "Busca y retorna una lista de todas las notas de un alumno específico.")
    @ApiResponse(responseCode = "200", description = "Lista de notas obtenida con éxito.")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado o sin notas.", content = @Content)
    public ResponseEntity<List<NotasDto>> obtenerPorAlumno(@Parameter(description = "ID del alumno para el cual se buscan las notas.") @PathVariable Long idAlumno) {
        List<NotasDto> notas = notasService.buscarNotasPorAlumno(idAlumno);
        if (notas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notas);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva nota", description = "Crea y guarda una nueva nota en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Nota creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<NotasDto> crear(@Valid @RequestBody NotasDto notasDto) {
        return new ResponseEntity<>(notasService.guardarNota(notasDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una nota existente", description = "Actualiza la información de una nota por su ID.")
    @ApiResponse(responseCode = "200", description = "Nota actualizada con éxito.")
    @ApiResponse(responseCode = "404", description = "Nota no encontrada.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<NotasDto> modificar(@Parameter(description = "ID de la nota a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModNotasDto modNotasDto) {
        return ResponseEntity.ok(notasService.modificarNota(id, modNotasDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una nota", description = "Elimina una nota de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Nota eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Nota no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID de la nota a eliminar.", example = "1") @PathVariable Long id) {
        notasService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }
}