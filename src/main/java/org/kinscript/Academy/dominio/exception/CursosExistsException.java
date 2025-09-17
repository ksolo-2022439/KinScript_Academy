package org.kinscript.Academy.dominio.exception;

public class CursosExistsException extends RuntimeException{
    public CursosExistsException(String nombreCurso) {
        super("El curso con nombre '" + nombreCurso + "' ya existe.");
    }
}
