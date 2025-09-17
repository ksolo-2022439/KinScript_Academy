package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.ProfesorAsignacionDto;
import org.kinscript.Academy.dominio.service.ProfesorAsignacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor-asignaciones")
public class ProfesorAsignacionController {

    private final ProfesorAsignacionService asignacionService;

    public ProfesorAsignacionController(ProfesorAsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorAsignacionDto>> obtenerTodas() {
        return ResponseEntity.ok(asignacionService.obtenerTodo());
    }

    @GetMapping("/profesor/{idProfesor}")
    public ResponseEntity<List<ProfesorAsignacionDto>> obtenerPorProfesor(@PathVariable Long idProfesor) {
        return ResponseEntity.ok(asignacionService.obtenerAsignacionesPorProfesor(idProfesor));
    }

    @PostMapping
    public ResponseEntity<ProfesorAsignacionDto> crearAsignacion(@Valid @RequestBody ProfesorAsignacionDto asignacionDto) {
        return new ResponseEntity<>(asignacionService.guardarAsignacion(asignacionDto), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminarAsignacion(@Valid @RequestBody ProfesorAsignacionDto asignacionDto) {
        asignacionService.eliminarAsignacion(asignacionDto);
        return ResponseEntity.noContent().build();
    }
}