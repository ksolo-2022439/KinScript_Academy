package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.CarrerasDto;
import org.kinscript.Academy.dominio.dto.ModCarrerasDto;
import org.kinscript.Academy.dominio.service.CarrerasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarrerasController {

    private final CarrerasService carrerasService;

    public CarrerasController(CarrerasService carrerasService) {
        this.carrerasService = carrerasService;
    }

    @GetMapping
    public ResponseEntity<List<CarrerasDto>> obtenerTodas() {
        List<CarrerasDto> carreras = carrerasService.obtenerTodo();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrerasDto> obtenerPorId(@PathVariable Long id) {
        CarrerasDto carrera = carrerasService.buscarPorCodigo(id);
        if (carrera == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carrera);
    }

    @PostMapping
    public ResponseEntity<CarrerasDto> crear(@Valid @RequestBody CarrerasDto carrerasDto) {
        CarrerasDto creada = carrerasService.guardarGrados(carrerasDto);
        return ResponseEntity.ok(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrerasDto> modificar(@PathVariable Long id, @Valid @RequestBody ModCarrerasDto modCarrerasDto) {
        CarrerasDto actualizada = carrerasService.modificarGrados(id, modCarrerasDto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        carrerasService.eliminarGrados(id);
        return ResponseEntity.noContent().build();
    }
}