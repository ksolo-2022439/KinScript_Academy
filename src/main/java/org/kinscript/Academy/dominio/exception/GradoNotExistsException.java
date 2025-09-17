package org.kinscript.Academy.dominio.exception;

public class GradoNotExistsException extends RuntimeException {

    public GradoNotExistsException(Long codigo) {
        super("No existe un grado con el ID: " + codigo);
    }
}