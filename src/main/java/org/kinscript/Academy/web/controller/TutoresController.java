package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.service.TutoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@Tag(name = "Tutores", description = "Operaciones CRUD sobre los tutores.")
public class TutoresController {
    private final TutoresService tutoresService;

    public TutoresController(TutoresService tutoresService) {
        this.tutoresService = tutoresService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los tutores", description = "Retorna una lista de todos los tutores registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de tutores obtenida con éxito.")
    public ResponseEntity<List<TutoresDto>> obtenerTodo() {
        return ResponseEntity.ok(tutoresService.obtenerTodo());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un tutor por ID", description = "Busca y retorna un tutor específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Tutor encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Tutor no encontrado.", content = @Content)
    public ResponseEntity<TutoresDto> buscarPorCodigo(@Parameter(description = "ID del tutor a buscar.", example = "1") @PathVariable("id") Integer idTutor) {
        return tutoresService.buscarPorCodigo(idTutor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo tutor", description = "Crea y guarda un nuevo tutor en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Tutor creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<TutoresDto> guardarTutor(@RequestBody TutoresDto tutorDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tutoresService.guardarTutor(tutorDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un tutor existente", description = "Actualiza la información de un tutor por su ID.")
    @ApiResponse(responseCode = "200", description = "Tutor actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Tutor no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<TutoresDto> modificarTutor(@Parameter(description = "ID del tutor a modificar.", example = "1") @PathVariable("id") Integer idTutor, @RequestBody ModTutoresDto modTutoresDto) {
        TutoresDto updatedTutor = tutoresService.modificarTutor(idTutor, modTutoresDto);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un tutor", description = "Elimina un tutor de la base de datos por su ID.")
    @ApiResponse(responseCode = "200", description = "Tutor eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Tutor no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminarTutor(@Parameter(description = "ID del tutor a eliminar.", example = "1") @PathVariable("id") Integer idTutor) {
        if (tutoresService.eliminarTutor(idTutor)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}