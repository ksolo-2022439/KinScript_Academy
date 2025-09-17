package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Secciones;
import org.springframework.data.repository.CrudRepository;

public interface CrudSeccionesEntity extends CrudRepository<Secciones, Long> {

    Secciones findFirstByNombreSeccion (String nombreSeccion);
}
