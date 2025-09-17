package org.kinscript.Academy.dominio.exception;

public class CursosNotExistsException extends RuntimeException {
    public CursosNotExistsException(Long codigo) {
        super("No existe un curso con el ID: " + codigo);
    }
}
