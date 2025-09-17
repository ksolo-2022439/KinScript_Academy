package org.kinscript.Academy.web.controller;

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
public class AlumnosController {

    private final AlumnosService alumnosService;

    public AlumnosController(AlumnosService alumnosService) {
        this.alumnosService = alumnosService;
    }

    @GetMapping
    public ResponseEntity<List<AlumnosDto>> obtenerTodos() {
        return ResponseEntity.ok(alumnosService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnosDto> obtenerPorId(@PathVariable Long id) {
        AlumnosDto alumno = alumnosService.buscarPorCodigo(id);
        return (alumno != null) ? ResponseEntity.ok(alumno) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AlumnosDto> crear(@Valid @RequestBody AlumnosDto alumnosDto) {
        AlumnosDto creado = alumnosService.guardarAlumno(alumnosDto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnosDto> modificar(@PathVariable Long id, @Valid @RequestBody ModAlumnosDto modAlumnosDto) {
        AlumnosDto actualizado = alumnosService.modificarAlumno(id, modAlumnosDto);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnosService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }
}