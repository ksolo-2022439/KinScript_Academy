package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModJornadasDto(
        @NotBlank(message = "El nombre de la jornada es obligatorio")
        String nombreJornada
) {
}
