package org.kinscript.Academy.web.controller;

import org.kinscript.Academy.dominio.dto.ModTutoresDto;
import org.kinscript.Academy.dominio.dto.TutoresDto;
import org.kinscript.Academy.dominio.service.TutoresService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutoresController {
    private final TutoresService tutoresService;

    public TutoresController(TutoresService tutoresService) {
        this.tutoresService = tutoresService;
    }

    @GetMapping
    public ResponseEntity<List<TutoresDto>> obtenerTodo() {
        return ResponseEntity.ok(tutoresService.obtenerTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutoresDto> buscarPorCodigo(@PathVariable("id") Integer idTutor) {
        return tutoresService.buscarPorCodigo(idTutor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TutoresDto> guardarTutor(@RequestBody TutoresDto tutorDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tutoresService.guardarTutor(tutorDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutoresDto> modificarTutor(@PathVariable("id") Integer idTutor, @RequestBody ModTutoresDto modTutoresDto) {
        TutoresDto updatedTutor = tutoresService.modificarTutor(idTutor, modTutoresDto);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTutor(@PathVariable("id") Integer idTutor) {
        if (tutoresService.eliminarTutor(idTutor)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}