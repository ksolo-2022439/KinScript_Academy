package org.kinscript.Academy.dominio.exception;

public class AlumnoNotExistsException extends RuntimeException {
    public AlumnoNotExistsException(Long codigo) {
        super("No existe un alumno con el ID: " + codigo);
    }
}