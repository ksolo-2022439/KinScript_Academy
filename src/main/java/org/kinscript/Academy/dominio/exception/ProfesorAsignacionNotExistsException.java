package org.kinscript.Academy.dominio.exception;

public class ProfesorAsignacionNotExistsException extends RuntimeException {
    public ProfesorAsignacionNotExistsException(Integer idProfesor, Integer idCurso, Integer idGrado, Integer idSeccion) {
        super("No existe la asignación para el profesor " + idProfesor + ", curso " + idCurso +
                ", grado " + idGrado + " y sección " + idSeccion + ".");
    }
}