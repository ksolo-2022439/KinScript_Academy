package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ModAlumnosDto(
        @NotBlank(message = "El carnet del alumno es obligatorio")
        @Size(max = 20, message = "El carnet no puede exceder los 20 caracteres")
        String carnetAlumno,
        @NotBlank(message = "El nombre del alumno es obligatorio")
        String nombreCompleto,

        @NotBlank(message = "El apellido del alumno es obligatorio")
        String apellidoCompleto,

        @NotBlank(message = "El email académico es obligatorio")
        @Email(message = "Debe proporcionar un email válido")
        String emailAcademico,

        @NotBlank(message = "La contraseña es obligatoria")
        String contrasena,

        @NotBlank(message = "La dirección es obligatoria")
        String direccion,

        @NotNull(message = "El ID del grado es obligatorio")
        Long idGrado,

        @NotNull(message = "El ID de la sección es obligatorio")
        Long idSeccion,

        Long idJornada,

        Long idCarrera,

        @NotNull(message = "El ID del tutor es obligatorio")
        Long idTutor) {
}