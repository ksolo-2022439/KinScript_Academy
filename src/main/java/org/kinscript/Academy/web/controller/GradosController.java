package org.kinscript.Academy.web.controller;


import org.kinscript.Academy.dominio.dto.GradosDto;
import org.kinscript.Academy.dominio.dto.ModGradosDto;
import org.kinscript.Academy.dominio.service.GradosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grados")
public class GradosController {

    private final GradosService gradosService;

    public GradosController(GradosService gradosService) {
        this.gradosService = gradosService;
    }

    // Obtener todos los grados
    @GetMapping
    public ResponseEntity<List<GradosDto>> obtenerTodos() {
        List<GradosDto> grados = gradosService.obtenerTodo();
        return ResponseEntity.ok(grados);
    }

    // Obtener grado por ID
    @GetMapping("/{id}")
    public ResponseEntity<GradosDto> obtenerPorId(@PathVariable Long id) {
        GradosDto grado = gradosService.buscarPorCodigo(id);
        if (grado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grado);
    }

    // Crear nuevo grado
    @PostMapping
    public ResponseEntity<GradosDto> crear(@Valid @RequestBody GradosDto gradosDto) {
        GradosDto creado = gradosService.guardarGrados(gradosDto);
        return ResponseEntity.ok(creado);
    }

    // Modificar grado existente
    @PutMapping("/{id}")
    public ResponseEntity<GradosDto> modificar(@PathVariable Long id, @Valid @RequestBody ModGradosDto modGradosDto) {
        GradosDto actualizado = gradosService.modificarGrados(id, modGradosDto);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar grado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        gradosService.eliminarGrados(id);
        return ResponseEntity.noContent().build();
    }
}
