package org.kinscript.Academy.dominio.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIServiceColegio {
    @UserMessage("""
            Generar un saludo de bienvenida a la plataforma de un colegio.
            Usa menos de 120 caracteres y hazlo con un estilo amigable
            """)
    String generarSaludo();
}
