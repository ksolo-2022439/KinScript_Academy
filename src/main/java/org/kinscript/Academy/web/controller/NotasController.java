package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.NotasDto;
import org.kinscript.Academy.dominio.dto.ModNotasDto;
import org.kinscript.Academy.dominio.service.NotasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    private final NotasService notasService;

    public NotasController(NotasService notasService) {
        this.notasService = notasService;
    }

    @GetMapping
    public ResponseEntity<List<NotasDto>> obtenerTodas() {
        return ResponseEntity.ok(notasService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotasDto> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(notasService.buscarPorCodigo(id));
    }

    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<NotasDto>> obtenerPorAlumno(@PathVariable Integer idAlumno) {
        List<NotasDto> notas = notasService.buscarNotasPorAlumno(idAlumno);
        if (notas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notas);
    }

    @PostMapping
    public ResponseEntity<NotasDto> crear(@Valid @RequestBody NotasDto notasDto) {
        return new ResponseEntity<>(notasService.guardarNota(notasDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotasDto> modificar(@PathVariable Integer id, @Valid @RequestBody ModNotasDto modNotasDto) {
        return ResponseEntity.ok(notasService.modificarNota(id, modNotasDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        notasService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }
}