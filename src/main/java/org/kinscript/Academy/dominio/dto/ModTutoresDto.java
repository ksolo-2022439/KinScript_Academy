package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModTutoresDto(
        @NotBlank(message = "El nombre del tutor es obligatorio")
        String nombreTutor
) {
}