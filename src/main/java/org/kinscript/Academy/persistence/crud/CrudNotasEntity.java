package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Notas;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CrudNotasEntity extends CrudRepository<Notas, Integer> {

    Optional<Notas> findByIdAlumnoAndIdCurso(Long idAlumno, Long idCurso);

    List<Notas> findByIdAlumno(Long idAlumno);
}