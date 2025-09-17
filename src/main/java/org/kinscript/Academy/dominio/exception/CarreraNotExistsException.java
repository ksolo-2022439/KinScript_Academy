package org.kinscript.Academy.dominio.exception;

public class CarreraNotExistsException extends RuntimeException {
    public CarreraNotExistsException(Long codigo) {
        super("No existe una carrera con el ID: " + codigo);
    }
}