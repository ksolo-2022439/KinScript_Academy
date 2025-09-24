package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import org.kinscript.Academy.dominio.service.GradosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grados")
@Tag(name = "Grados", description = "Operaciones CRUD sobre los grados académicos.")
public class GradosController {

    private final GradosService gradosService;

    public GradosController(GradosService gradosService) {
        this.gradosService = gradosService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los grados", description = "Retorna una lista de todos los grados académicos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de grados obtenida con éxito.")
    public ResponseEntity<List<GradosDto>> obtenerTodos() {
        List<GradosDto> grados = gradosService.obtenerTodo();
        return ResponseEntity.ok(grados);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un grado por ID", description = "Busca y retorna un grado específico por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Grado encontrado y devuelto.")
    @ApiResponse(responseCode = "404", description = "Grado no encontrado.", content = @Content)
    public ResponseEntity<GradosDto> obtenerPorId(@Parameter(description = "ID del grado a buscar.", example = "1") @PathVariable Long id) {
        GradosDto grado = gradosService.buscarPorCodigo(id);
        if (grado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grado);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo grado", description = "Crea y guarda un nuevo grado en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Grado creado con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<GradosDto> crear(@Valid @RequestBody GradosDto gradosDto) {
        GradosDto creado = gradosService.guardarGrados(gradosDto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar un grado existente", description = "Actualiza la información de un grado por su ID.")
    @ApiResponse(responseCode = "200", description = "Grado actualizado con éxito.")
    @ApiResponse(responseCode = "404", description = "Grado no encontrado.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<GradosDto> modificar(@Parameter(description = "ID del grado a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModGradosDto modGradosDto) {
        GradosDto actualizado = gradosService.modificarGrados(id, modGradosDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un grado", description = "Elimina un grado de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Grado eliminado con éxito.")
    @ApiResponse(responseCode = "404", description = "Grado no encontrado.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID del grado a eliminar.", example = "1") @PathVariable Long id) {
        gradosService.eliminarGrados(id);
        return ResponseEntity.noContent().build();
    }
}