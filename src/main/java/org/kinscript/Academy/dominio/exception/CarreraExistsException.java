package org.kinscript.Academy.dominio.exception;

public class CarreraExistsException extends RuntimeException {
    public CarreraExistsException(String nombre) {
        super("La carrera con el nombre '" + nombre + "' ya existe.");
    }
}