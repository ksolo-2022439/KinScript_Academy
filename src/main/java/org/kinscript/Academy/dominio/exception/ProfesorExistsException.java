package org.kinscript.Academy.dominio.exception;

public class ProfesorExistsException extends RuntimeException {

    public ProfesorExistsException(String email) {
        super("El profesor con email '" + email + "' ya existe.");
    }
}