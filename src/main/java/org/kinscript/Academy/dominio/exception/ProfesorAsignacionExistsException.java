package org.kinscript.Academy.dominio.exception;

public class ProfesorAsignacionExistsException extends RuntimeException {
    public ProfesorAsignacionExistsException(Long idProfesor, Long idCurso, Long idGrado, Long idSeccion) {
        super("La asignación para el profesor " + idProfesor + ", curso " + idCurso +
                ", grado " + idGrado + " y sección " + idSeccion + " ya existe.");
    }
}