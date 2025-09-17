package org.kinscript.Academy.dominio.exception;

public class JornadaExistsException extends RuntimeException {
    public JornadaExistsException(String nombreJornada) {
        super("La jornada con nombre '" + nombreJornada +"' ya existe." );
    }
}
