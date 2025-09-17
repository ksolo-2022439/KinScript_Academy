package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Cursos;
import org.springframework.data.repository.CrudRepository;

public interface CrudCursosEntity extends CrudRepository<Cursos, Long>{
    Cursos findFirstByNombreCurso (String nombreCurso);
}
