package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record CarrerasDto(
        Integer idCarrera,
        @NotBlank(message = "La seleccion de una carrera debe ser obligatoria")
        String nombreCarrera
) {
}
