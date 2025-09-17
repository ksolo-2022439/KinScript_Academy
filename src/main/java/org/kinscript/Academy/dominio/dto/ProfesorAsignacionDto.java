package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record ProfesorAsignacionDto(
        @NotNull(message = "El ID del profesor es obligatorio")
        Integer idProfesor,

        @NotNull(message = "El ID del curso es obligatorio")
        Integer idCurso,

        @NotNull(message = "El ID del grado es obligatorio")
        Integer idGrado,

        @NotNull(message = "El ID de la sección es obligatorio")
        Integer idSeccion,

        Integer idJornada // puede ser nulo
) {
}