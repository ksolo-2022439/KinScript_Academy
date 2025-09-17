package org.kinscript.Academy.dominio.exception;

public class JornadaNotExistsException extends RuntimeException {
    public JornadaNotExistsException(Long codigo) {
        super("No existe una jornada con el ID: " + codigo);
    }
}
