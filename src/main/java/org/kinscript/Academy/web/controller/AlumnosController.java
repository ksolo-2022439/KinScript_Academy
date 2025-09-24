package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.AlumnosDto;
import org.kinscript.Academy.dominio.dto.ModAlumnosDto;
import org.kinscript.Academy.dominio.service.AlumnosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@Tag(name = "Alumnos", description = "Operaciones CRUD sobre los alumnos de la academia")
public class AlumnosController {

    private final AlumnosService alumnosService;

    public AlumnosController(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los alumnos", description = "Retorna una lista de todos los alumnos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de alumnos obtenida con éxito.")
    public ResponseEntity<List<AlumnosDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnosService.obtenerTodo());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un alumno por ID", description = "Busca y retorna un alumno específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Alumno encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado.", content = @Content)
    public ResponseEntity<AlumnosDto> obtenerPorId(@Parameter(description = "ID del alumno a buscar.", example = "1") @PathVariable Long id) {
        AlumnosDto alumno = alumnosService.buscarPorCodigo(id);
        return (alumno != null) ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo alumno", description = "Crea y guarda un nuevo alumno en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Alumno creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<AlumnosDto> crear(@Valid @RequestBody AlumnosDto alumnosDto) {
        AlumnosDto creado = alumnosService.guardarAlumno(alumnosDto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un alumno existente", description = "Actualiza la información de un alumno existente por su ID.")
    @ApiResponse(responseCode = "200", description = "Alumno actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<AlumnosDto> modificar(@Parameter(description = "ID del alumno a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModAlumnosDto modAlumnosDto) {
        AlumnosDto actualizado = alumnosService.modificarAlumno(id, modAlumnosDto);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un alumno", description = "Elimina un alumno de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Alumno eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Alumno no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID del alumno a eliminar.", example = "1") @PathVariable Long id) {
        alumnosService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }
}