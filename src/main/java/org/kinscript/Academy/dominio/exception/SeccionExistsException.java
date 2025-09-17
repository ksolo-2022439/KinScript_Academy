package org.kinscript.Academy.dominio.exception;

public class SeccionExistsException extends RuntimeException {
    public SeccionExistsException(String nombre) {
        super("La sección con nombre '" + nombre + "' ya existe.");
    }
}