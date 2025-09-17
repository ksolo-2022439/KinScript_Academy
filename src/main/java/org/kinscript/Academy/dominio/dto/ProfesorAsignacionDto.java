package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record ProfesorAsignacionDto(
        @NotNull(message = "El ID del profesor es obligatorio")
        Long idProfesor,

        @NotNull(message = "El ID del curso es obligatorio")
        Long idCurso,

        @NotNull(message = "El ID del grado es obligatorio")
        Long idGrado,

        @NotNull(message = "El ID de la sección es obligatorio")
        Long idSeccion,

        Long idJornada // puede ser nulo
) {
}