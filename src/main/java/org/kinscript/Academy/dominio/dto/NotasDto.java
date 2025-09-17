package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

import java.math.BigDecimal;

public record NotasDto(
        Long idNota,

        @NotNull(message = "El ID del alumno es obligatorio")
        Long idAlumno,

        @NotNull(message = "El ID del curso es obligatorio")
        Long idCurso,

        @DecimalMin(value = "0.00", message = "La nota no puede ser menor a 0")
        @DecimalMax(value = "100.00", message = "La nota no puede ser mayor a 100")
        BigDecimal bimestre1,

        @DecimalMin(value = "0.00", message = "La nota no puede ser menor a 0")
        @DecimalMax(value = "100.00", message = "La nota no puede ser mayor a 100")
        BigDecimal bimestre2,

        @DecimalMin(value = "0.00", message = "La nota no puede ser menor a 0")
        @DecimalMax(value = "100.00", message = "La nota no puede ser mayor a 100")
        BigDecimal bimestre3,

        @DecimalMin(value = "0.00", message = "La nota no puede ser menor a 0")
        @DecimalMax(value = "100.00", message = "La nota no puede ser mayor a 100")
        BigDecimal bimestre4
) {
}