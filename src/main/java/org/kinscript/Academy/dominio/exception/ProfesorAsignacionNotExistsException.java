package org.kinscript.Academy.dominio.exception;

public class ProfesorAsignacionNotExistsException extends RuntimeException {
    public ProfesorAsignacionNotExistsException(Long idProfesor, Long idCurso, Long idGrado, Long idSeccion) {
        super("No existe la asignación para el profesor " + idProfesor + ", curso " + idCurso +
                ", grado " + idGrado + " y sección " + idSeccion + ".");
    }
}