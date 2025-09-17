package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.CoordinadoresEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudCoordinadoresEntity extends CrudRepository<CoordinadoresEntity, Long> {
    CoordinadoresEntity findByNombre(String nombreCompleto);
}
