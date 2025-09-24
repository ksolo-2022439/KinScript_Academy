package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.CoordinadoresDto;
import org.kinscript.Academy.dominio.dto.ModCoordinadoresDto;
import org.kinscript.Academy.dominio.service.CoordinadoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordinadores")
public class CoordinadoresController {

    private final CoordinadoresService coordinadoresService;

    public CoordinadoresController(CoordinadoresService coordinadoresService) {
        this.coordinadoresService = coordinadoresService;
    }

    @GetMapping
    public ResponseEntity<List<CoordinadoresDto>> obtenerTodos() {
        return ResponseEntity.ok(coordinadoresService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordinadoresDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(coordinadoresService.buscarPorCodigo(id));
    }

    @PostMapping
    public ResponseEntity<CoordinadoresDto> crear(@Valid @RequestBody CoordinadoresDto coordinadoresDto) {
        return new ResponseEntity<>(coordinadoresService.guardarCoordinador(coordinadoresDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordinadoresDto> modificar(@PathVariable Long id, @Valid @RequestBody ModCoordinadoresDto modCoordinadoresDto) {
        return ResponseEntity.ok(coordinadoresService.modificarCoordinador(id, modCoordinadoresDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        coordinadoresService.eliminarCoordinador(id);
        return ResponseEntity.noContent().build();
    }
}