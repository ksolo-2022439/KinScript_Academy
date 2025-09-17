package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record JornadasDto(
        Integer idJornada,
        @NotBlank(message = "El nombre de la jornada es obligatorio")
        String nombreJornada
) {
}
