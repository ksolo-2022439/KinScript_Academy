package org.kinscript.Academy.dominio.exception;

public class CoordinadorExistsException extends RuntimeException {
    public CoordinadorExistsException(String email) {
        super("Ya existe un coordinador con el email: " + email);
    }
}