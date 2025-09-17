package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record GradoCursoDto(
        @NotNull(message = "El ID del grado es obligatorio")
        Integer idGrado,

        @NotNull(message = "El ID del curso es obligatorio")
        Integer idCurso
) {
}