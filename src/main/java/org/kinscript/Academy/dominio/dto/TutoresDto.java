package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TutoresDto(

        Integer idTutor,
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
