package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record ProfesoresDto(

        Integer idProfesor,
        @NotBlank(message = "El nombre del profesor es obligatorio")
        String nombreCompleto,
        @NotBlank(message = "El apellido del profesor es obligatorio")
        String apellidoCompleto,
        @NotBlank(message = "La direccion del profesor es obligatoria")
        String direccion,
        @NotBlank(message = "El numero de telefono del profesro es obligatorio")
        String numeroTelefono,
        @NotBlank(message = "El correo del profesor es obligatorio")
        @Email(message = "El formato del email del profesor no es válido")
        String email,
        @NotBlank(message = "La contrasena es obligatoria")
        String contrasena

) {
}
