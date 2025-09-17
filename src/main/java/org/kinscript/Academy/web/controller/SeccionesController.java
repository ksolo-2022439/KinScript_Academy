package org.kinscript.Academy.web.controller;

import org.kinscript.Academy.dominio.dto.SeccionesDto;
import org.kinscript.Academy.dominio.dto.ModSeccionesDto;
import org.kinscript.Academy.dominio.service.SeccionesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secciones")
public class SeccionesController {

    private final SeccionesService seccionesService;

    public SeccionesController(SeccionesService seccionesService) {
        this.seccionesService = seccionesService;
    }

    @GetMapping
    public ResponseEntity<List<SeccionesDto>> obtenerTodas() {
        return ResponseEntity.ok(seccionesService.obtenerSeccion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeccionesDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(seccionesService.buscarSeccion(id));
    }

    @PostMapping
    public ResponseEntity<SeccionesDto> crear(@RequestBody SeccionesDto seccionesDto) {
        SeccionesDto creado = seccionesService.guardarSeccion(seccionesDto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeccionesDto> actualizar(@PathVariable Long id, @RequestBody ModSeccionesDto modSeccionesDto) {
        return ResponseEntity.ok(seccionesService.modificarSeccion(id, modSeccionesDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        seccionesService.eliminarSeccion(id);
        return ResponseEntity.noContent().build();
    }
}