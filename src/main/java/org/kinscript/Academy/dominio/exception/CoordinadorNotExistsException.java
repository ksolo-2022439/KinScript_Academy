package org.kinscript.Academy.dominio.exception;

public class CoordinadorNotExistsException extends RuntimeException {
    public CoordinadorNotExistsException(Long idCoordinador) {
        super("No se encontró un coordinador con el ID: " + idCoordinador);
    }
}