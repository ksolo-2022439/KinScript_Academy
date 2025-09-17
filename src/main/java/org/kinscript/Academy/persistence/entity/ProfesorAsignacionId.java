package org.kinscript.Academy.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorAsignacionId implements Serializable {
    private Long idProfesor;
    private Long idCurso;
    private Long idGrado;
    private Long idSeccion;
}