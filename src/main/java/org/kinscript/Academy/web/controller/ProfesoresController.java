package org.kinscript.Academy.web.controller;

import org.kinscript.Academy.dominio.dto.ModProfesoresDto;
import org.kinscript.Academy.dominio.dto.ProfesoresDto;
import org.kinscript.Academy.dominio.service.ProfesoresService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {

    private final ProfesoresService profesoresService;

    public ProfesoresController(ProfesoresService profesoresService) {
        this.profesoresService = profesoresService;
    }

    // Obtener todos los profesores
    @GetMapping
    public ResponseEntity<List<ProfesoresDto>> obtenerTodos() {
        List<ProfesoresDto> profesores = profesoresService.obtenerTodo();
        return ResponseEntity.ok(profesores);
    }

    // Obtener profesor por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProfesoresDto> obtenerPorId(@PathVariable Long id) {
        ProfesoresDto profesor = profesoresService.buscarPorId(id);
        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profesor);
    }

    // Crear nuevo profesor
    @PostMapping
    public ResponseEntity<ProfesoresDto> crear(@Valid @RequestBody ProfesoresDto profesoresDto) {
        ProfesoresDto creado = profesoresService.guardarProfesor(profesoresDto);
        return ResponseEntity.ok(creado);
    }

    // Modificar profesor existente
    @PutMapping("/{id}")
    public ResponseEntity<ProfesoresDto> modificar(@PathVariable Long id, @Valid @RequestBody ModProfesoresDto modProfesoresDto) {
        ProfesoresDto actualizado = profesoresService.modificarProfesor(id, modProfesoresDto);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar profesor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesoresService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }
}