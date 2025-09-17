package org.kinscript.Academy.dominio.exception;

public class GradoExistsException extends RuntimeException {

    public GradoExistsException(String nombreGrado) {
        super("El grado con nombre '" + nombreGrado + "' ya existe.");
    }
}
