package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Grados;
import org.springframework.data.repository.CrudRepository;

public interface CrudGradosEntity extends CrudRepository<Grados, Long> {

    Grados findFirstByNombre (String nombreGrado);
}
