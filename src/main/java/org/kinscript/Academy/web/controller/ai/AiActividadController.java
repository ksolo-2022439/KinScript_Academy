package org.kinscript.Academy.web.controller.ai;

import org.kinscript.Academy.dominio.dto.SolicitudDto;
import org.kinscript.Academy.dominio.service.AIServiceColegio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiActividadController {

    private final AIServiceColegio aiService;

    public AiActividadController(AIServiceColegio aiService) {
        this.aiService = aiService;
    }

    //Metodo para sugerir la actividad
    @PostMapping("/sugerir")
    public ResponseEntity<String> generarSugerenciaActividad(@RequestBody SolicitudDto solicitudDto) {
        return ResponseEntity.ok(this.aiService.generarActividad(solicitudDto.preferencias()));
    }
}
