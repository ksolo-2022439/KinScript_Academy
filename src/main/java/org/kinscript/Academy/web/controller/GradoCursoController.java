package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.GradoCursoDto;
import org.kinscript.Academy.dominio.service.GradoCursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gradocursos")
public class GradoCursoController {

    private final GradoCursoService gradoCursoService;

    public GradoCursoController(GradoCursoService gradoCursoService) {
        this.gradoCursoService = gradoCursoService;
    }

    @GetMapping
    public ResponseEntity<List<GradoCursoDto>> obtenerTodos() {
        return ResponseEntity.ok(gradoCursoService.obtenerTodo());
    }

    @GetMapping("/grado/{idGrado}")
    public ResponseEntity<List<GradoCursoDto>> obtenerPorGrado(@PathVariable Integer idGrado) {
        return ResponseEntity.ok(gradoCursoService.obtenerCursosPorGrado(idGrado));
    }

    @PostMapping
    public ResponseEntity<GradoCursoDto> crearAsociacion(@Valid @RequestBody GradoCursoDto gradoCursoDto) {
        return new ResponseEntity<>(gradoCursoService.guardarAsociacion(gradoCursoDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/grado/{idGrado}/curso/{idCurso}")
    public ResponseEntity<Void> eliminarAsociacion(@PathVariable Integer idGrado, @PathVariable Integer idCurso) {
        gradoCursoService.eliminarAsociacion(idGrado, idCurso);
        return ResponseEntity.noContent().build();
    }
}