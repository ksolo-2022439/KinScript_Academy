package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Profesores;
import org.springframework.data.repository.CrudRepository;

public interface CrudProfesoresEntity extends CrudRepository<Profesores, Long> {

    Profesores findFirstByEmail (String email);
}