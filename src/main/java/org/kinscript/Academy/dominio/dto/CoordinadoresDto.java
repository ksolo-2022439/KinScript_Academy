package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CoordinadoresDto(
        Long idCoordinador,

        @NotBlank(message = "El nombre es obligatorio")
        String nombreCompleto,

        @NotBlank(message = "El apellido es obligatorio")
        String apellidoCompleto,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "Debe ser un formato de email válido")
        String email,

        @NotBlank(message = "La contraseña es obligatoria")
        String contrasena,

        @NotNull(message = "El ID del grado es obligatorio")
        Long idGrado
) {
}