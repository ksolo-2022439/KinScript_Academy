package org.kinscript.Academy.dominio.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ModNotasDto(
        @NotNull(message = "El ID del alumno es obligatorio")
        Integer idAlumno,

        @NotNull(message = "El ID del curso es obligatorio")
        Integer idCurso,

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