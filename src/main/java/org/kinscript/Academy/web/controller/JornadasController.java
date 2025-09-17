package org.kinscript.Academy.web.controller;

import jakarta.validation.Valid;
import org.kinscript.Academy.dominio.dto.JornadasDto;
import org.kinscript.Academy.dominio.dto.ModJornadasDto;
import org.kinscript.Academy.dominio.service.JornadasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornadas")
public class JornadasController {

    private final JornadasService jornadasService;

    public  JornadasController(JornadasService jornadasService) { this.jornadasService = jornadasService; }

    //Obtener todas las jornadas
    @GetMapping
    public ResponseEntity<List<JornadasDto>> obtenerTodos() {
        List<JornadasDto> jornadas = jornadasService.obtenerTodo();
        return ResponseEntity.ok(jornadas);
    }

    //Obtener jornada por ID
    @GetMapping("/{id}")
    public ResponseEntity<JornadasDto> obtenerPorId(@PathVariable Long id){
        JornadasDto jornada = jornadasService.buscarPorCodigo(id);
        if (jornada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jornada);
    }

    //Crear nueva jornada
    @PostMapping
    public ResponseEntity<JornadasDto> crear(@Valid @RequestBody JornadasDto jornadasDto){
        JornadasDto creado = jornadasService.guardarJornadas(jornadasDto);
        return ResponseEntity.ok(creado);
    }

    //Modificar jornada existente
    @PutMapping("/{id}")
    public ResponseEntity<JornadasDto> modificar(@PathVariable Long id, @Valid @RequestBody ModJornadasDto modJornadasDto){
        JornadasDto actualizado = jornadasService.modificarJornadas(id, modJornadasDto);
        return ResponseEntity.ok(actualizado);
    }

    //Eliminar jornada
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        jornadasService.eliminarJornadas(id);
        return ResponseEntity.noContent().build();
    }
}
