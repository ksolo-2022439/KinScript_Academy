package org.kinscript.Academy.dominio.exception;

public class GradoCursoNotExistsException extends RuntimeException {
    public GradoCursoNotExistsException(Integer idGrado, Integer idCurso) {
        super("No existe una asociación para el grado ID " + idGrado + " y el curso ID " + idCurso + ".");
    }
}