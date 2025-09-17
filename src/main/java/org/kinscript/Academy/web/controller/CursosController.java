package org.kinscript.Academy.web.controller;

import org.kinscript.Academy.dominio.dto.CursosDto;
import org.kinscript.Academy.dominio.dto.ModCursosDto;
import org.kinscript.Academy.dominio.service.CursosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursosController {
    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    // Obtener todos los grados
    @GetMapping
    public ResponseEntity<List<CursosDto>> obtenerTodos() {
        List<CursosDto> cursos = cursosService.obtenerTodo();
        return ResponseEntity.ok(cursos);
    }

    // Obtener curso por ID
    @GetMapping("/{id}")
    public ResponseEntity<CursosDto> obtenerPorId(@PathVariable Long id) {
        CursosDto curso = cursosService.buscarPorCodigo(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(curso);
    }

    // Crear nuevo curso
    @PostMapping
    public ResponseEntity<CursosDto> crear(@Valid @RequestBody CursosDto cursosDto) {
        CursosDto creado = cursosService.guardarCursos(cursosDto);
        return ResponseEntity.ok(creado);
    }

    // Modificar curso existente
    @PutMapping("/{id}")
    public ResponseEntity<CursosDto> modificar(@PathVariable Long id, @Valid @RequestBody ModCursosDto modCursosDto) {
        CursosDto actualizado = cursosService.modificarCursos(id, modCursosDto);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        cursosService.eliminarCursos(id);
        return ResponseEntity.noContent().build();
    }
}
