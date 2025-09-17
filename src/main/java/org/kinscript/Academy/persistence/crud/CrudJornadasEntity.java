package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Jornadas;
import org.springframework.data.repository.CrudRepository;

public interface CrudJornadasEntity extends CrudRepository<Jornadas, Long> {

    Jornadas findFirstByNombreJornada (String nombreJornada);
}
