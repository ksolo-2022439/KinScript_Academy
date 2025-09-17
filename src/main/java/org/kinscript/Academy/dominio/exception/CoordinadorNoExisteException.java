package org.kinscript.Academy.dominio.exception;

public class CoordinadorNoExisteException extends RuntimeException {
    public CoordinadorNoExisteException(Long codigo) {
        super("Coordinador no encontrado" + codigo);
    }
}
