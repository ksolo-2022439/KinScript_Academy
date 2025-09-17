package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModTutoresDto(
        @NotBlank(message = "El nombre del tutor es obligatorio")
        String nombreCompleto,
        @NotBlank(message = "El apellido del tutor es obligatorio")
        String apellidoCompleto,
        @NotBlank(message = "El numero de telefono es obligatorio")
        String numeroTelefono,
        @NotBlank(message = "La direccion es obligatoria")
        String direccion
) {
}