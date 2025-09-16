package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record GradosDto(
        Integer idGrado,
        @NotBlank(message = "El nombre del grado es obligatorio")
        String nombreGrado
) {
}