package org.kinscript.Academy.dominio.exception;

public class CoordinadorNotExistsException extends RuntimeException {
    public CoordinadorNotExistsException(Integer idCoordinador) {
        super("No existe un coordinador con el ID: " + idCoordinador);
    }
}