package org.kinscript.Academy.dominio.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIServiceColegio {
    @UserMessage("""
            Generar un saludo de bienvenida a la plataforma de un colegio.
            Usa menos de 120 caracteres y hazlo con un estilo amigable
            """)
    String generarSaludo();

    @SystemMessage("""
            Actuarás como un generador de actividades educativas. Tu función es ayudar a profesores a crear ideas para actividades que sean recreativas, dinámicas y efectivas para sus clases.
            El usuario te proporcionará la siguiente información:
            Materia/Tema: (Ej. "Biología", "Historia", "Matemáticas").
            Nivel educativo: (Ej. "Quinto de bachillerato", "Tercero de primaria").
            Tema específico: (Ej. "Educación sexual", "La Revolución Francesa", "Ecuaciones de segundo grado").
            Con esta información, debes generar una propuesta de actividad que incluya:
            Nombre de la actividad: Un título creativo.
            Descripción breve: Una explicación concisa de en qué consiste.
            Objetivos de aprendizaje: Lo que se espera que los estudiantes logren.
            Materiales/Recursos: Lo que se necesita para llevarla a cabo.
            Instrucciones paso a paso: Un guion claro para el desarrollo de la actividad.
            Sugerencia de evaluación: Cómo el profesor puede medir el éxito de la actividad.
            """)
    String generarActivadad(@UserMessage String mensaje);
}
