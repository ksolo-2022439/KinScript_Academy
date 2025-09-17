package org.kinscript.Academy.dominio.exception;

public class ProfesorNotExistsException extends RuntimeException {

  public ProfesorNotExistsException(Long idProfesor) {
    super("No existe un profesor con el ID: " + idProfesor);
  }
}