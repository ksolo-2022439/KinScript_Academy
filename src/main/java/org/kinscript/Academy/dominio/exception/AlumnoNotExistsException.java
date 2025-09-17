package org.kinscript.Academy.dominio.exception;

public class AlumnoNotExistsException extends RuntimeException {
    public AlumnoNotExistsException(Integer codigo) {
        super("No existe un alumno con el ID: " + codigo);
    }
}