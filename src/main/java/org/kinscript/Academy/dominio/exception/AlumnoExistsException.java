package org.kinscript.Academy.dominio.exception;

public class AlumnoExistsException extends RuntimeException {
    public AlumnoExistsException(String carnet) {
        super("El alumno con el carnet '" + carnet + "' ya existe.");
    }
}