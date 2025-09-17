package org.kinscript.Academy.dominio.exception;

public class NotaNotExistsException extends RuntimeException {
    public NotaNotExistsException(Integer idNota) {
        super("No existe un registro de nota con el ID: " + idNota);
    }
}