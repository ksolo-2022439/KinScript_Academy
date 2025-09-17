package org.kinscript.Academy.persistence.crud;

import org.kinscript.Academy.persistence.entity.Carreras;
import org.springframework.data.repository.CrudRepository;

public interface CrudCarrerasEntity extends CrudRepository<Carreras, Integer> {
    Carreras findByNombreCarrera(String nombreCarrera);
}