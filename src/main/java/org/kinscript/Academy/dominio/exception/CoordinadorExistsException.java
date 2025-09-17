package org.kinscript.Academy.dominio.exception;

public class CoordinadorExistsException extends RuntimeException {
    public CoordinadorExistsException(String email) {
        super("El coordinador con el email '" + email + "' ya existe.");
    }
}