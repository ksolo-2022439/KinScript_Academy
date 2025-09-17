package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotNull;

public record GradoCursoDto(
        @NotNull(message = "El ID del grado es obligatorio")
        Long idGrado,

        @NotNull(message = "El ID del curso es obligatorio")
        Long idCurso
) {
}