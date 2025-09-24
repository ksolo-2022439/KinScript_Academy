package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Profesores;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CrudProfesoresEntity extends CrudRepository<Profesores, Long> {

    Optional<Profesores> findFirstByEmail (String email);
}