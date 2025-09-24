package org.kinscript.Academy.web.controller;

import org.kinscript.Academy.dominio.service.AIServiceColegio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiSaludoController {

    @Autowired
    private final AIServiceColegio aiService;


    public AiSaludoController(AIServiceColegio aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/saludo")
    public String saludoColegio() {
        return this.aiService.generarSaludo();
    }
}
