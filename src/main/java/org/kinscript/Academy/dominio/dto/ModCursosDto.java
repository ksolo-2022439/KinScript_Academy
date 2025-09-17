package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ModCursosDto (
        @NotBlank(message = "El nombre del grado es obligatorio")
        String nombreCurso

){

}
