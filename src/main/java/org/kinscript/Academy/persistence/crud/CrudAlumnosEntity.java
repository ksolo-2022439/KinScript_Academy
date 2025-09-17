package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Alumnos;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudAlumnosEntity extends CrudRepository<Alumnos, Integer> {
    Optional<Alumnos> findByCarnetAlumno(String carnetAlumno);
}