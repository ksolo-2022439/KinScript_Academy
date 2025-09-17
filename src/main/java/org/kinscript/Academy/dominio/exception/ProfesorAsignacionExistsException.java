package org.kinscript.Academy.dominio.exception;

public class ProfesorAsignacionExistsException extends RuntimeException {
    public ProfesorAsignacionExistsException(Integer idProfesor, Integer idCurso, Integer idGrado, Integer idSeccion) {
        super("La asignación para el profesor " + idProfesor + ", curso " + idCurso +
                ", grado " + idGrado + " y sección " + idSeccion + " ya existe.");
    }
}