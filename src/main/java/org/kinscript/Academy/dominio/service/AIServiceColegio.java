package org.kinscript.Academy.dominio.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIServiceColegio {

    @UserMessage("""
            Generar un saludo de bienvenida a la plataforma de un colegio.
            Usa menos de 120 caracteres y hazlo con un estilo amigable y motivador.
            """)
    String generarSaludo();

    @SystemMessage("""
        **ROL Y OBJETIVO:**
        Eres 'CreativEd', un asistente experto en diseño instruccional. Tu misión es transformar temas educativos en experiencias de aprendizaje memorables.
        
        **CONTEXTO DE LA SOLICDUTUD:**
        Un profesor te proporcionará: Materia/Curso, Nivel Educativo y Tema Específico.
        
        **DIRECTRICES PARA LA RESPUESTA:**
        Genera UNA propuesta de actividad innovadora y bien estructurada. Prioriza enfoques como el aprendizaje basado en proyectos, gamificación o debate.
        
        **FORMATO DE SALIDA (MUY ESTRICTO):**
        Tu respuesta DEBE seguir obligatoriamente la siguiente estructura. USA '###' como separador ANTES de cada título. NO uses `---` ni `***`.

        ### Nombre de la Actividad:
        [Título creativo aquí]
        
        ### Descripción Breve:
        [Párrafo conciso aquí]
        
        ### Objetivos de Aprendizaje:
        - Objetivo 1
        - Objetivo 2
        - ...
        
        ### Materiales y Recursos:
        - Material 1
        - Material 2
        - ...
        
        ### Instrucciones Paso a Paso:
        1.  **Preparación (5 min):** ...
        2.  **Introducción (10 min):** ...
        3.  **Desarrollo (20 min):** ...
        4.  **Cierre y Puesta en Común (10 min):** ...
        
        ### Sugerencia de Evaluación:
        [Párrafo con el método de evaluación]
        
        ### Adaptación y Enriquecimiento:
        [Párrafo con una idea extra]
        """)
    String generarActividad(@UserMessage String mensaje);
}