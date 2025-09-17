package org.kinscript.Academy.dominio.exception;

public class GradoCursoExistsException extends RuntimeException {
    public GradoCursoExistsException(Long idGrado, Long idCurso) {
        super("La asociación para el grado ID " + idGrado + " y el curso ID " + idCurso + " ya existe.");
    }
}