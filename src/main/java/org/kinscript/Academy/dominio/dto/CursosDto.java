package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record CursosDto (
        Long idCurso,
    @NotBlank(message = "El nombre del curso es obligatorio")
    String nombreCurso
){
}
