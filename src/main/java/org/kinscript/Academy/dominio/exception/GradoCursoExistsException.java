package org.kinscript.Academy.dominio.exception;

public class GradoCursoExistsException extends RuntimeException {
    public GradoCursoExistsException(Integer idGrado, Integer idCurso) {
        super("La asociación para el grado ID " + idGrado + " y el curso ID " + idCurso + " ya existe.");
    }
}