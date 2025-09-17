package org.kinscript.Academy.dominio.exception;

public class NotaExistsException extends RuntimeException {
    public NotaExistsException(Long idAlumno, Long idCurso) {
        super("Ya existe un registro de notas para el alumno con ID '" + idAlumno + "' en el curso con ID '" + idCurso + "'.");
    }
}