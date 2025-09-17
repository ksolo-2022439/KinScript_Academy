package org.kinscript.Academy.dominio.exception;


public class SeccionNotExistsException extends RuntimeException {
    public SeccionNotExistsException(Long id) {
        super("No existe una sección con ID: " + id);
    }
}