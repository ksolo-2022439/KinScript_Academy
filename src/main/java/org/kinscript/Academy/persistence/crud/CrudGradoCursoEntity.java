package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.GradoCurso;
import org.kinscript.Academy.persistence.entity.GradoCursoId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudGradoCursoEntity extends CrudRepository<GradoCurso, GradoCursoId> {

    List<GradoCurso> findByIdGrado(Long idGrado);
}