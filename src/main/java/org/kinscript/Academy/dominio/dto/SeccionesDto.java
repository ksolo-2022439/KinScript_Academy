package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record SeccionesDto(
        Long idSeccion,
        @NotBlank(message = "El nombre de la sección es obligatorio")
        String nombreSeccion
) {
}