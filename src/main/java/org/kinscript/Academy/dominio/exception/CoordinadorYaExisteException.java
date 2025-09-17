package org.kinscript.Academy.dominio.exception;

public class CoordinadorYaExisteException extends RuntimeException{
    public CoordinadorYaExisteException(String nombreCompleto) {
        super("Este coordinador ya existe, el coordinador es:" + nombreCompleto);
    }
}