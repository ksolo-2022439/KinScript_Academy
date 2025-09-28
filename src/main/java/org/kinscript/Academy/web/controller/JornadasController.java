package org.kinscript.Academy.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.service.JornadasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jornadas")
@Tag(name = "Jornadas", description = "Operaciones CRUD sobre las jornadas de trabajo.")
public class JornadasController {

    private final JornadasService jornadasService;

    public JornadasController(JornadasService jornadasService) {
        this.jornadasService = jornadasService;
    }

    @GetMapping
    @Operation(summary = "Obtener todas las jornadas", description = "Retorna una lista de todas las jornadas de trabajo registradas.")
    @ApiResponse(responseCode = "200", description = "Lista de jornadas obtenida con éxito.")
    public ResponseEntity<List<JornadasDto>> obtenerTodos() {
        List<JornadasDto> jornadas = jornadasService.obtenerTodo();
        return ResponseEntity.ok(jornadas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una jornada por ID", description = "Busca y retorna una jornada específica por su identificador único.")
    @ApiResponse(responseCode = "200", description = "Jornada encontrada y devuelta.")
    @ApiResponse(responseCode = "404", description = "Jornada no encontrada.", content = @Content)
    public ResponseEntity<JornadasDto> obtenerPorId(@Parameter(description = "ID de la jornada a buscar.", example = "1") @PathVariable Long id) {
        JornadasDto jornada = jornadasService.buscarPorCodigo(id);
        if (jornada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jornada);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva jornada", description = "Crea y guarda una nueva jornada en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Jornada creada con éxito.")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<JornadasDto> crear(@Valid @RequestBody JornadasDto jornadasDto) {
        JornadasDto creado = jornadasService.guardarJornadas(jornadasDto);
        return ResponseEntity.ok(creado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modificar una jornada existente", description = "Actualiza la información de una jornada por su ID.")
    @ApiResponse(responseCode = "200", description = "Jornada actualizada con éxito.")
    @ApiResponse(responseCode = "404", description = "Jornada no encontrada.", content = @Content)
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos.", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<JornadasDto> modificar(@Parameter(description = "ID de la jornada a modificar.", example = "1") @PathVariable Long id, @Valid @RequestBody ModJornadasDto modJornadasDto) {
        JornadasDto actualizado = jornadasService.modificarJornadas(id, modJornadasDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una jornada", description = "Elimina una jornada de la base de datos por su ID.")
    @ApiResponse(responseCode = "204", description = "Jornada eliminada con éxito.")
    @ApiResponse(responseCode = "404", description = "Jornada no encontrada.", content = @Content)
    public ResponseEntity<Void> eliminar(@Parameter(description = "ID de la jornada a eliminar.", example = "1") @PathVariable Long id) {
        jornadasService.eliminarJornadas(id);
        return ResponseEntity.noContent().build();
    }
}