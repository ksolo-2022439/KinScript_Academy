package org.kinscript.Academy.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorAsignacionId implements Serializable {
    private Integer idProfesor;
    private Integer idCurso;
    private Integer idGrado;
    private Integer idSeccion;
}