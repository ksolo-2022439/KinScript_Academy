package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Tutores;
import org.springframework.data.repository.CrudRepository;

public interface CrudTutoresEntity extends CrudRepository<Tutores, Long> {

    Tutores findFirstByNombre (String nombreCompleto);
}
